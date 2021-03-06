package org.influxdb.impl;

import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;
import retrofit.mime.TypedInput;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class InfluxDBErrorHandlerTest {

    @Test
    public void testHandleErrorAndCloseTheStream() {
        final String influxDbInternalError = "InfluxDB internal error";
        String url = "http://localhost:8096";

        final AtomicBoolean closed = new AtomicBoolean(false);
        Response response = new Response(url, 500, "Internal error",
		        Arrays.asList(new Header("content-type", "text/plain")), new TypedInput() {
            @Override
            public String mimeType() {
                return "text/plain";
            }

            @Override
            public long length() {
                return influxDbInternalError.getBytes(StandardCharsets.UTF_8).length;
            }

            @Override
            public InputStream in() throws IOException {
                return new ByteArrayInputStream(influxDbInternalError.getBytes(StandardCharsets.UTF_8)) {
                    @Override
                    public void close() throws IOException {
                        closed.set(true);
                    }
                };
            }
        });
        RetrofitError error = RetrofitError.httpError(url, response, null, null);
        Throwable throwable = new InfluxDBErrorHandler().handleError(error);

        Assert.assertEquals(throwable.getMessage(), influxDbInternalError, "Wrong error message");
        Assert.assertTrue(closed.get(), "Stream is not closed");
    }
}

package org.influxdb.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.client.Response;

class InfluxDBErrorHandler implements ErrorHandler {
	@Override
	public Throwable handleError(final RetrofitError cause) {
		Response r = cause.getResponse();
		if (r != null && r.getStatus() >= 400) {
			InputStream is = null;
            try {
	            is = r.getBody().in();
                String body = Helper.readStreamToString(is);
                return new RuntimeException(body);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
	            Helper.close(is);
            }
        }
		return cause;
	}
}

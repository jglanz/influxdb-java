package org.influxdb.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by jglanz on 2/17/15.
 */
public class Helper {

	public static void close(InputStream is) {
		try {
			if (is != null)
				is.close();
		} catch (Exception e) {}
	}

	public static String readStreamToString(InputStream is) throws Exception {
		int read;
		byte[] buf = new byte[1024];
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		while ((read = is.read(buf)) > -1) {
			os.write(buf,0,read);
		}

		return new String(os.toByteArray());

	}


}

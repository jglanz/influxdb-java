package org.influxdb;

import org.influxdb.impl.InfluxDBImpl;


/**
 * A Factory to create a instance of a InfluxDB Database adapter.
 * 
 * @author stefan.majer [at] gmail.com
 * 
 */
public enum InfluxDBFactory {
	;
	/**
	 * Create a connection to a InfluxDB.
	 * 
	 * @param url
	 *            the url to connect to.
	 * @param username
	 *            the username which is used to authorize against the influxDB instance.
	 * @param password
	 *            the password for the username which is used to authorize against the influxDB
	 *            instance.
	 * @return a InfluxDB adapter suitable to access a InfluxDB.
	 */
	public static InfluxDB connect(final String url, final String username, final String password) {
		return new InfluxDBImpl(url, username, password);
	}

}

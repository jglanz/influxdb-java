package org.influxdb.dto;


import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * Representation of a InfluxDB Server which is part of a cluster.
 * 
 * @author stefan.majer [at] gmail.com
 * 
 */
public class Server {
	private int id;
	private String protobufConnectString;

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * @return the protobufConnectString
	 */
	public String getProtobufConnectString() {
		return this.protobufConnectString;
	}

	/**
	 * @param protobufConnectString
	 *            the protobufConnectString to set
	 */
	public void setProtobufConnectString(final String protobufConnectString) {
		this.protobufConnectString = protobufConnectString;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}

}

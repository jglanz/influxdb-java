package org.influxdb.dto;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * Representation of the response for a influxdb ping.
 * 
 * @author stefan.majer [at] gmail.com
 * 
 */
public class Pong {
	private String status;
	private long responseTime;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(final String status) {
		this.status = status;
	}

	/**
	 * @return the responseTime
	 */
	public long getResponseTime() {
		return this.responseTime;
	}

	/**
	 * @param responseTime
	 *            the responseTime to set
	 */
	public void setResponseTime(final long responseTime) {
		this.responseTime = responseTime;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}

}
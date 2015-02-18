package org.influxdb.dto;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * Representation of a influxdb database.
 * 
 * @author stefan.majer [at] gmail.com
 * 
 */
public class Database {
	private final String name;

	/**
	 * @param name
	 *            the name of the database.
	 */
	public Database(final String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}

}
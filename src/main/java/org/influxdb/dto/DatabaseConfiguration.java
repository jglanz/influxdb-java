package org.influxdb.dto;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.ArrayList;
import java.util.List;


/**
 * Configuration for a Database.
 * 
 * @author stefan.majer [at] gmail.com
 * 
 */
public class DatabaseConfiguration {
	private final String name;
	private final List<ShardSpace> spaces = new ArrayList<>();
	private final List<String> continuousQueries = new ArrayList<>();

	/**
	 * @param name
	 *            the name of the Database.
	 */
	public DatabaseConfiguration(final String name) {
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
	 * @return the spaces
	 */
	public List<ShardSpace> getSpaces() {
		return this.spaces;
	}

	/**
	 * @param space
	 *            the space to add
	 */
	public void addSpace(final ShardSpace space) {
		this.spaces.add(space);
	}

	/**
	 * @return the continuousQueries
	 */
	public List<String> getContinuousQueries() {
		return this.continuousQueries;
	}

	/**
	 * @param continuousQuery
	 *            the continuousQuery add
	 */
	public void addContinuousQueries(final String continuousQuery) {
		this.continuousQueries.add(continuousQuery);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}

}

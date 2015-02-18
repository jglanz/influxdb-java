package org.influxdb.dto;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.List;



/**
 * Representation of all Shards.
 * 
 * @author stefan.majer [at] gmail.com
 * 
 */
public class Shards {
	private List<Shard> longTerm;
	private List<Shard> shortTerm;

	/**
	 * @return the longTerm
	 */
	public List<Shard> getLongTerm() {
		return this.longTerm;
	}

	/**
	 * @param longTerm
	 *            the longTerm to set
	 */
	public void setLongTerm(final List<Shard> longTerm) {
		this.longTerm = longTerm;
	}

	/**
	 * @return the shortTerm
	 */
	public List<Shard> getShortTerm() {
		return this.shortTerm;
	}

	/**
	 * @param shortTerm
	 *            the shortTerm to set
	 */
	public void setShortTerm(final List<Shard> shortTerm) {
		this.shortTerm = shortTerm;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}

}

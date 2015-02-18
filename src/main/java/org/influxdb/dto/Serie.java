package org.influxdb.dto;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.*;


/**
 * Representation of a InfluxDB database serie.
 * 
 * @author stefan.majer [at] gmail.com
 * 
 */
public class Serie {
	private final String name;
	String[] columns;
	Object[][] points;

	/**
	 * Builder for a new Serie.
	 * 
	 * A typical usage would look like:
	 * 
	 * <br/>
	 * <code>
	 * Serie serie = new Serie.Builder("serieName")
	 * 			.columns("time", "cpu_idle")
	 * 			.values(System.currentTimeMillis(), 0.97)
	 * 			.values(System.currentTimeMillis(), 0.99).build();
	 * </code>
	 */
	public static class Builder {
		private final String name;
		private final List<String> columns = new ArrayList<>();
		private final List<List<Object>> valueRows = new ArrayList<>();

		/**
		 * @param name
		 *            the name of the Serie to create.
		 */
		public Builder(final String name) {
			super();
			this.name = name;
		}

		/**
		 * @param columnNames
		 *            the array of names of all columns.
		 * @return this Builder instance.
		 */
		public Builder columns(final String... columnNames) {
			this.columns.addAll(Arrays.asList(columnNames));
			return this;
		}

		/**
		 * @param values
		 *            the values for a single row.
		 * @return this Builder instance.
		 */
		public Builder values(final Object... values) {
			this.valueRows.add(Arrays.asList(values));
			return this;
		}

		/**
		 * Create a Serie instance.
		 * 
		 * @return the created Serie.
		 */
		public Serie build() {
			Serie serie = new Serie(this.name);
			serie.columns = this.columns.toArray(new String[this.columns.size()]);
			Object[][] points = new Object[this.valueRows.size()][this.columns.size()];
			int row = 0;
			for (List<Object> values : this.valueRows) {
				points[row] = values.toArray();
				row++;
			}
			serie.points = points;
			return serie;
		}
	}

	/**
	 * @param name
	 *            the name of the serie.
	 */
	Serie(final String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the columns
	 */
	public String[] getColumns() {
		return this.columns;
	}

	/**
	 * @return the Points as a List of Maps with columnName to value.
	 */
	public List<Map<String, Object>> getRows() {
		List<Map<String, Object>> rows = new ArrayList<>();
		for (Object[] point : this.points) {
			int column = 0;
			Map<String, Object> row = new HashMap<>();
			for (Object value : point) {
				row.put(this.columns[column], value);
				column++;
			}
			rows.add(row);
		}
		return rows;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this).toString();
	}

}
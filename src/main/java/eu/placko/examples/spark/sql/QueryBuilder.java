package eu.placko.examples.spark.sql;

public class QueryBuilder {
	private Long limit = 0L;

	public QueryBuilder setLimit(Long limit) {
		this.limit = limit;
		return this;
	}

	public String build() {
		String sql = "SELECT title FROM tmp_episodes";
		if (limit != null && limit.longValue() > 0) {
			sql = sql + " limit " + limit;
		}
		return sql;
	}
}
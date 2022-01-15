package eu.placko.examples.spark.sql;

public class HiveBuilder {
	public String buildDB() {
		String sql = "CREATE DATABASE IF NOT EXISTS episodes LOCATION '/user/hive/databases/episodes.db'";
		return sql;
	}
	
	public String buildTB() {
		String sql = "DROP TABLE IF EXISTS episodes.episodes";
		return sql;
	}
	
	public String buildTB(String path) {
		String sql = "CREATE EXTERNAL TABLE episodes.episodes(title string) STORED AS PARQUET LOCATION 'hdfs://nameservice1" + path + "episodes_titles_only.parquet'";
		return sql;
	}
}
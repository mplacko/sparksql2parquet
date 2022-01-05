package eu.placko.examples.spark.config;

import org.apache.spark.sql.SparkSession;

public class SparkConfig {
	public static SparkSession createSparkSession() {
		SparkSession spark = SparkSession.builder()
				.appName("sparksql2parquet")
				//.master("local[1]")
				//.master("yarn")
				.config("spark.sql.broadcastTimeout","36000")
				.getOrCreate();
		
		return spark;
	}
}
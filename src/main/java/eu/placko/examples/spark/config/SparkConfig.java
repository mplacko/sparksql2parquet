package eu.placko.examples.spark.config;

import org.apache.spark.sql.SparkSession;
import java.io.File;

public class SparkConfig {
	public static SparkSession createSparkSession() {
		String episodesLocation = new File("episodes").getAbsolutePath();
		SparkSession spark = SparkSession
				.builder()
				.appName("sparksql2parquet")
				//.master("local[1]")
				//.master("yarn")
				.config("spark.sql.broadcastTimeout","36000")
				.config("spark.sql.warehouse.dir", episodesLocation)
				.enableHiveSupport()
				.getOrCreate();	
		return spark;
	}
}
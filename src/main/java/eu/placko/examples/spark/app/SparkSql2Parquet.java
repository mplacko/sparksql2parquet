package eu.placko.examples.spark.app;

import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.SaveMode;

import eu.placko.examples.spark.config.SparkConfig;
import eu.placko.examples.spark.sql.QueryBuilder;

public class SparkSql2Parquet {
	private final static Logger LOGGER = Logger.getLogger(SparkSql2Parquet.class.getName());
	
	public static void main(String[] args) {
		if (args.length != 1) {
		    LOGGER.info("wrong input! usage: /user/<REPLACE>/sparksql2parquet/");
		    return;
		}
		String path = args[0];
		
		SparkSession sparkSession = SparkConfig.createSparkSession();
		LOGGER.info("Started Spark Session");
		
		Dataset<Row> parquetFileDF = sparkSession.read().parquet(path + "episodes.parquet");
		parquetFileDF.createOrReplaceTempView("tmp_episodes");
		LOGGER.info("Created temp view");
		
		String query = new QueryBuilder().setLimit(null).build();
		Dataset<Row> episodesDF = sparkSession.sql(query);
		episodesDF
			//.select("title")
			.write()
			.mode(SaveMode.Overwrite)
			.parquet(path + "episodes_titles_only.parquet");
		LOGGER.info("Written to the new parquet");
	}
}
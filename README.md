# sparksql2parquet
An example for reading (quering) and writing a parquet file

### HOW TO CONFIGURE THE PROJECT
- `sparksql2parquet.sh`
```sh
keytabUser=<REPLACE>
keytab=/etc/security/keytabs/<REPLACE>.keytab
appArtifact="/<REPLACE>/sparksql2parquet-$appVersion.jar /user/<REPLACE>/sparksql2parquet/"
```
- `INPUT`
```sh
HDFS: /user/<REPLACE>/sparksql2parquet/episodes.parquet
parquet location: \src\main\resources
avro source: downloaded from https://github.com/apache/hive/blob/master/data/files/episodes.avro
```
- `OUTPUT`
```sh
HDFS: /user/<REPLACE>/sparksql2parquet/episodes_titles_only.parquet
```

## Building and Running

### Build
To build the application it is required to have this installed:
- `Java 9`
- `Maven 3.x`

Then just run this:
```sh
mvn clean install
```

### Submit to Spark cluster
For running spark application see shell script inside `/scripts` dir.
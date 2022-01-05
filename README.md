# sparksql2parquet
An example for reading (quering) and writing a parquet file

### HOW TO CONFIGURE THE PROJECT
- `sparksql2parquet.sh`
```sh
keytabUser=<REPLACE>
keytab=/etc/security/keytabs/<REPLACE>.keytab
appArtifact="/<REPLACE>/sparksql2parquet-$appVersion.jar /user/<REPLACE>/sparksql2parquet/"
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
For running spark application see shell scripts inside `/scripts` dir.
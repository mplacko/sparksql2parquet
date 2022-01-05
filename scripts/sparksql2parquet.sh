#!/bin/sh


on_error() {
  printf "\n\nAn error occurred!\n";
  exit 1;
}
trap on_error ERR


keytabUser=<REPLACE>
keytab=/etc/security/keytabs/<REPLACE>.keytab
appClass=eu.placko.examples.spark.app.SparkSql2Parquet

appVersion="1.0.0-SNAPSHOT"
appArtifact="/<REPLACE>/sparksql2parquet-$appVersion.jar /user/<REPLACE>/sparksql2parquet/"

echo "Start kinit"
kinit -kt $keytab $keytabUser
echo "Kinit done"

# only for "testing/debugging" purposes  --deploy-mode client \
spark-submit \
    --master yarn \
    --deploy-mode cluster \
    --class $appClass \
    --conf spark.executor.memory=12G \
    --conf spark.driver.memory=4G \
    --conf spark.dynamicAllocation.minExecutors=1 \
    --conf spark.dynamicAllocation.maxExecutors=5 \
    --conf spark.executor.cores=5 \
    $appArtifact

exit 0;
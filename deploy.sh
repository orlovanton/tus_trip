#!/bin/sh
# My first script

echo "mvn clean install"
mvn clean install -P prod
STATUS=$?
if [ $STATUS -eq 0 ]; then
echo "done"
else
echo "Failed"
exit 0
fi
echo "stoping app"
ssh root@46.101.187.30 service tus-aggregator stop
echo "done"
echo "removing jar"
ssh root@46.101.187.30 rm /home/tus-aggregator.jar
echo "done"
echo "Deploying jar"
scp  ./target/tus-aggregator.jar root@46.101.187.30:/home/
echo "starting app"
ssh root@46.101.187.30 service tus-aggregator start
echo "DONE"
exit 0


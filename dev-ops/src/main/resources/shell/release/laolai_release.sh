#!/usr/bin/env bash

#   Function : reg  pc  once_without_proxy 1~100
#
#   Require :
#        ${REQUIRE}
#   Usage :
#            1.
#            2.

SERVICE_TYPE=laolai


ARGS="--service.type=${SERVICE_TYPE}"
QUERY_ARGS="\-\-service.type=${SERVICE_TYPE}"
PID=`ps -aux | grep temple-application-crawler-query-1.0.0.jar | grep "${QUERY_ARGS}" |  grep -v grep | awk '{print $2}' | egrep '[1-9][0-9]+'`
PID_ARRAY=(${PID// / })

#while [[ ! -z "$PID" ]]
#do
#    kill -9 $PID
#    echo "restart service. PID = $PID"
#    PID=`ps -aux | grep temple-application-crawler-query-1.0.0.jar | grep "${QUERY_ARGS}" |  grep -v grep | awk '{print $2}' | egrep '[1-9][0-9]+' | sed -n '1p'`
#done

/data/query/shell/crawler.sh $ARGS

sleep 30

for i in "${PID_ARRAY[@]}";
do
    kill -9 $PID
    echo "restart service. PID = $PID"
done

echo ${SERVICE_TYPE}+"_"+"service restart completed"
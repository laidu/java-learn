#!/usr/bin/env bash

#   Function : reg  pc  once_without_proxy 1~100
#
#   Require :
#        ${REQUIRE}
#   Usage :
#            1.
#            2.

SERVICE_TYPE=reg
USE_PROXY=false
PROXY_TYPE=once_without_proxy
INDEX_CODE=1
MAX_LIMIT=100
REG_TYPE=pc

ARGS="--service.type=${SERVICE_TYPE} --use.proxy=${USE_PROXY} --proxy.type=${PROXY_TYPE} --max.limit=${MAX_LIMIT} --index.code=${INDEX_CODE} --reg.type=${REG_TYPE}"
QUERY_ARGS="\-\-service.type=${SERVICE_TYPE}\ \-\-use.proxy=${USE_PROXY}\ \-\-proxy.type=${PROXY_TYPE}\ \-\-max.limit=${MAX_LIMIT}\ \-\-index.code=${INDEX_CODE} \-\-reg.type=${REG_TYPE}"
PID_OLD=`ps -aux | grep temple-application-crawler-query-1.0.0.jar | grep "${QUERY_ARGS}" |  grep -v grep | awk '{print $2}' | egrep '[1-9][0-9]+'`
PID_OLD_ARRAY=(${PID_OLD// / })

/data/query/shell/crawler.sh $ARGS

sleep 30

PID_NEW=`ps -aux | grep temple-application-crawler-query-1.0.0.jar | grep "${QUERY_ARGS}" |  grep -v grep | awk '{print $2}' | egrep '[1-9][0-9]+'`
PID_NEW_ARRAY=(${PID_NEW// / })

if ${PID_NEW_ARRAY[@]} > ${PID_OLD[@]}; then

    for i in "${PID_ARRAY[@]}";
    do
        kill -9 $PID
        echo "restart service. PID = $PID"
    done

fi

echo ${SERVICE_TYPE}+"_"+${REG_TYPE}+"_"+${INDEX_CODE}+"_"+${MAX_LIMIT}+"_"+"service restart completed"
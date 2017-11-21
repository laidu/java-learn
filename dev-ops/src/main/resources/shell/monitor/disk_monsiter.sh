#!/usr/bin/env bash

#   Function : monitor reg server log disk
#
#   Require :
#        nagios
#   Usage :
#            1. 
#            2.

LOG_PATH="/data/process/crawler/logs"

DISK_STATUS=$(eval "/usr/local/nagios/libexec/check_disk -w 90% -c 10% -p /dev/xvdb | grep OK | wc -l")

if [ ${DISK_STATUS} != 1 ]
then
    echo "disk capacity warring"
    echo "" > ${LOG_PATH}/alpha.log
fi

DISK_STATUS=$(eval "/usr/local/nagios/libexec/check_disk -w 5% -c 1% -p /dev/xvdb | grep OK | wc -l")
if [ ${DISK_STATUS} != 1 ]
then
    echo "disk capacity warring"
    echo "" > ${LOG_PATH}/logstash-business.log_json
fi
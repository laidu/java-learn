#!/usr/bin/env bash

:'   Function :
        login adsl proxy slave
    Require :
        ssh sshpass
    Usage :
            1. alias proxy_slave="sh ~/bin/proxy_slave.sh root 123123"
            2. proxy_slave 10.10.10.101:22 root 123123
'

LOGIN_NAME=$1
PASSWORD=$2
ARGS=$3

ip_address=$(cut -d ':' -f1 <<< ${ARGS})
ip_port=$(cut -d ':' -f2 <<< ${ARGS})

echo "sshpass -p ${PASSWORD} ssh ${LOGIN_NAME}@${ip_address} -p ${ip_port}"
sshpass -p ${PASSWORD} ssh ${LOGIN_NAME}@${ip_address} -p ${ip_port}
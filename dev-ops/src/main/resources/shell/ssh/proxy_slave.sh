#!/usr/bin/env bash

:'   Function :
        login adsl proxy slave
    Require :
        ssh sshpass
    Usage :
            1. alias proxy_slave="sh ~/bin/proxy_slave.sh root 123123"
            2. proxy_slave 10.10.10.101:22 root 123123
';

ARGS=$1
USERNAME=$2
PASSWORD=$3

ip_address= echo ${ARGS} | cut -d ':' -f1
ip_port= echo ${ARGS} | cut -d ':' -f2

sshpass -p ${PASSWORD} ssh ${USERNAME}@${ip_address} -p ${ip_port}
#!/usr/bin/env bash
'''
 ssh tool

 require :
    sshpass
    ssh client

 example :
    sh ssh.sh [ip:port] [password]
'''
host_port=$1

port=${host_port#*:}
host=${host_port%:*}

password=$2
sshpass -p $password ssh root@$host -p $port

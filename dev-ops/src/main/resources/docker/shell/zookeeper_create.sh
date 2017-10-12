#! /bin/bash
name=$1
port1=$2
port2=$3
port3=$4
docker run --name zookeeper-$name -p0.0.0.0:$port1:2181 -p0.0.0.0:$port2:2888 -p0.0.0.0:$port3:3888  --restart always -d zookeeper

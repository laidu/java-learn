#! /bin/bash

kibana_root=/Users/laidu/Files/data/docker/kibana
pubilc_path=/Users/laidu/Files/data/docker/upload
docker run --name zookeeper-$name -p0.0.0.0:$port1:2181 -p0.0.0.0:$port2:2888 -p0.0.0.0:$port3:3888   -d zookeeper

#docker run --restart always \
docker run --rm -d --net=host \
    -v ${pubilc_path}/upload:/root \
    --name zookeeper-dev zookeeper
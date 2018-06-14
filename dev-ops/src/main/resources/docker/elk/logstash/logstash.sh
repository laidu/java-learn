#!/usr/bin/env bash

logstash_root=/Users/laidu/Files/data/docker/logstash
pubilc_path=/Users/laidu/Files/data/docker/upload

#docker run  -d --restart=always \
docker run  --rm -d --net=host --name logstash-dev \
	-v /etc/hosts:/etc/hosts \
	-v ${logstash_root}/config:/usr/share/logstash/config \
	-v ${logstash_root}/data:/usr/share/logstash/data \
	-v ${pubilc_path}/upload:/root \
	daocloud.io/laidu/elk-logstash6
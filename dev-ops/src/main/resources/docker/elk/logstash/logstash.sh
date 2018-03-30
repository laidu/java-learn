#!/usr/bin/env bash

logstash_root=/Users/laidu/Files/data/docker/logstash
pubilc_path=/Users/laidu/Files/data/docker/upload

docker run --rm -it \
    -v ${logstash_root}/config/logstash.yml:/usr/share/logstash/config/logstash.yml \
    -v ${pubilc_path}/upload:/root \
    daocloud.io/laidu/kibana_6

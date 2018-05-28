#!/bin/bash

kafka_root=/Users/laidu/Files/data/docker/kibana
pubilc_path=/Users/laidu/Files/data/docker/upload

docker run --rm --net=host -d daocloud.io/laidu/devops-kafka


docker run -p 2181:2181 -p 9092:9092 --env ADVERTISED_HOST=`docker-machine ip \`docker-machine active\`` --env ADVERTISED_PORT=9092 spotify/kafka

export KAFKA=`docker-machine ip \`docker-machine active\``:9092
kafka-console-producer.sh --broker-list $KAFKA --topic test
export ZOOKEEPER=`docker-machine ip \`docker-machine active\``:2181
kafka-console-consumer.sh --zookeeper $ZOOKEEPER --topic test


docker run --rm -d  \
    -p 2181:2181 \
    -p 9092:9092 \
    --env ADVERTISED_HOST=`docker-machine ip \`docker-machine active\`` \
    --env ADVERTISED_PORT=9092 daocloud.io/laidu/devops-kafka

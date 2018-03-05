#! /bin/bash
mysql_root=/data/docker/mysql
#docker run  -d --restart=always \
docker run --rm --name es-dev  \
	-p 0.0.0.0:9200:9200 \
	-p 0.0.0.0:9300:9300 \
	-e discovery.type=single-node \
	-e xpack.security.enabled=false \
	-e ELASTIC_PASSWORD=es-dev \
	-v /data/docker/elk/elasticsearch/data:/usr/share/elasticsearch/data  \
	-v /etc/hosts:/etc/hosts  \
	daocloud.io/laidu/elasticsearch_6

#! /bin/bash
mysql_root=/data/docker/mysql
#docker run  -d --restart=always \
docker run --rm -d --name es-dev  \
	-p 0.0.0.0:9200:9200 \
	-p 0.0.0.0:9300:9300 \
	-e discovery.type=single-node \
	-e xpack.license.self_generated.type=trial \
	-e xpack.security.enabled=false \
	-e ELASTIC_PASSWORD=es-dev \
	-v /Users/laidu/Files/data/docker/elasticsearch/config/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml \
	-v /Users/laidu/Files/data/docker/elasticsearch/data:/usr/share/elasticsearch/data \
	-v /Users/laidu/Files/data/docker/upload/x-pack-core-6.2.2.jar:/usr/share/elasticsearch/plugins/x-pack/x-pack-core/x-pack-core-6.2.2.jar \
	-v /Users/laidu/Files/data/docker/upload:/root \
	-v /etc/hosts:/etc/hosts  \
	daocloud.io/laidu/elasticsearch_6

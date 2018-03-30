#! /bin/bash

kibana_root=/Users/laidu/Files/data/docker/kibana
pubilc_path=/Users/laidu/Files/data/docker/upload

#docker run  -d --restart=always \
docker run  --rm -d --name kibana-dev \
    -e elasticsearch.password=elastic \
	-e elasticsearch.password=es-dev \
	-e xpack.monitoring.enabled=true \
	-e xpack.monitoring.ui.container.elasticsearch.enabled=true \
	-p 5601:5601 \
	-v /etc/hosts:/etc/hosts \
	-v ${kibana_root}/config/kibana.yml:/usr/share/kibana/config/kibana.yml  \
	-v ${kibana_root}/optimize:/usr/share/kibana/optimize \
	-v ${pubilc_path}/upload:/root \
	daocloud.io/laidu/kibana_6
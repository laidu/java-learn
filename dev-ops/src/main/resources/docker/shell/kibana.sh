#! /bin/bash
#docker run  -d --restart=always \
docker run  --rm --name kibana-dev 
	-e elasticsearch.password=es-dev 
	-p 0.0.0.0:5601:5601 \
	-v /etc/hosts:/etc/hosts \
	-v /data/docker/elk/kinaba/config/kibana.yml:/usr/share/kibana/config/kibana.yml  \
	daocloud.io/laidu/kibana_6

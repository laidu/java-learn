#! /bin/bash
#docker run  -d --restart=always \
docker run  --rm -d --name kibana-dev \
    -e elasticsearch.password=elastic \
	-e elasticsearch.password=es-dev \
	-e xpack.monitoring.enabled=true \
	-e xpack.monitoring.ui.container.elasticsearch.enabled=true \
	-p 0.0.0.0:5601:5601 \
	-v /etc/hosts:/etc/hosts \
	-v /Users/laidu/Files/data/docker/kinaba/config/kibana.yml:/usr/share/kibana/config/kibana.yml  \
	-v /Users/laidu/Files/data/docker/kinaba/optimize:/usr/share/kibana/optimize \
	-v /Users/laidu/Files/data/docker/upload:/root \
	daocloud.io/laidu/kibana_6






curl -XPUT -u demo:ZGVtbzEyMzQ= 'http://localhost:9200/_xpack/license'  -H "Content-Type: application/json" -d \
'{
  "license": {
    "uid": "aa",
    "type": "platinum",
    "issue_date_in_millis": 1519689600000,
    "expiry_date_in_millis": 2524579200999,
    "max_nodes": 1000,
    "issued_to": "aa",
    "issuer": "Web Form",
    "signature": "AAAAAwAAAA019",
    "start_date_in_millis": 1519689600000
  }
}'
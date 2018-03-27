#! /bin/bash
mysql_root=/data/docker/mysql
#docker run  -d --restart=always \
docker run --rm -d --name es-dev  \
	-p 0.0.0.0:9200:9200 \
	-p 0.0.0.0:9300:9300 \
	-e discovery.type=single-node \
	-e ELASTIC_PASSWORD=es-dev \
	-e ES_JAVA_OPTS="-Xms3g -Xmx3g" \
	-v /Users/laidu/Files/data/docker/elasticsearch/config/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml \
	-v /Users/laidu/Files/data/docker/elasticsearch/data:/usr/share/elasticsearch/data \
	-v /Users/laidu/Files/data/docker/upload/x-pack-core-6.2.2.jar:/usr/share/elasticsearch/plugins/x-pack/x-pack-core/x-pack-core-6.2.2.jar \
	-v /Users/laidu/Files/data/docker/upload:/root \
	-v /etc/hosts:/etc/hosts \
	daocloud.io/laidu/elasticsearch_6


{"license":{"uid":"c6570128-85c2-4f72-8d8f-b1425455b9ee","type":"platinum","issue_date_in_millis":1515369600000,"expiry_date_in_millis":2524579200999,"max_nodes":10000,"issued_to":"elastic","issuer":"elastic","signature":"AAAAAwAAAA07qIy5rp9i1qa5VS3vAAABmC9ZN0hjZDBGYnVyRXpCOW5Bb3FjZDAxOWpSbTVoMVZwUzRxVk1PSmkxaktJRVl5MUYvUWh3bHZVUTllbXNPbzBUemtnbWpBbmlWRmRZb25KNFlBR2x0TXc2K2p1Y1VtMG1UQU9TRGZVSGRwaEJGUjE3bXd3LzRqZ05iLzRteWFNekdxRGpIYlFwYkJiNUs0U1hTVlJKNVlXekMrSlVUdFIvV0FNeWdOYnlESDc3MWhlY3hSQmdKSjJ2ZTcvYlBFOHhPQlV3ZHdDQ0tHcG5uOElCaDJ4K1hob29xSG85N0kvTWV3THhlQk9NL01VMFRjNDZpZEVXeUtUMXIyMlIveFpJUkk2WUdveEZaME9XWitGUi9WNTZVQW1FMG1DenhZU0ZmeXlZakVEMjZFT2NvOWxpZGlqVmlHNC8rWVVUYzMwRGVySHpIdURzKzFiRDl4TmM1TUp2VTBOUlJZUlAyV0ZVL2kvVk10L0NsbXNFYVZwT3NSU082dFNNa2prQ0ZsclZ4NTltbU1CVE5lR09Bck93V2J1Y3c9PQAAAQBXa2fLJmNxlfTsXWcKjk1Z7JdZF3wQmJwOTgVR306TV8IwvielPKIrF99El/ie0oaJqbMzH6Khz+aR4ugNc21j+AxK9PTJ6PupE4VYb4auHFGmwHJ9cst96xD4wH77XlSGkTKhm31ZwCQvL/j3+Qjr+PtGOPeiZM5F99AuLLNmYhHZLFHO+fI5feBWwppCVjFvygJf5jMsvbJQQwsGxjX26+PUy12+0eHD1wJWDfrTgaIQ//AaVxvv+bkwBWxgCvJcC7PLrHKdNgkuggU2+G2EXLqJX6stJAoH8R1NA0JAA5yDzdB8M4+shlgDckbcAdUsV6rjUlQwzjbsK/BPHY9A","start_date_in_millis":1515369600000}}

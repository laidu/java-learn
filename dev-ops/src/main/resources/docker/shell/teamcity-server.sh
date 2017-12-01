#! /bin/bash
name=$1
web_port=$2
port=$3
teamcityHome=/data/docker/teamcity/server

docker run -itd --restart=always --name teamcity-server-dev  \
	-v ${teamcityHome}/data:/data/teamcity_server/datadir \
	-v ${teamcityHome}/log:/opt/teamcity/logs  \
	-v /etc/hosts:/etc/hosts \
	-p 0.0.0.0:8111:8111 \
	jetbrains/teamcity-server

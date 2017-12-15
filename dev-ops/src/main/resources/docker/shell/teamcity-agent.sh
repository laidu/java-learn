#! /bin/bash
name=$1
web_port=$2
port=$3
teamcityHome=/data/docker/teamcity/agent

docker run -itd --restart=always --name teamcity-agent-dev -e SERVER_URL="http://172.17.5.93:8111"  \
	-p 0.0.0.0:9111:9090 \
	-v ${teamcityHome}/conf:/data/teamcity_agent/conf  \
	-v /var/run/docker.sock:/var/run/docker.sock \
	-v /etc/hosts:/etc/hosts \
	jetbrains/teamcity-agent

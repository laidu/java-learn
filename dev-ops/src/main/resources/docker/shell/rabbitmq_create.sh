#! /bin/bash
name=$1
port=$2
web_port=$3
docker run --restart=always -d -p0.0.0.0:$port:5672  -p0.0.0.0:$web_port:15672   --name rabbitmq-$name  rabbitmq:3-management
#docker run  -d -p0.0.0.0:$port:5672  -p0.0.0.0:$web_port:15672   --name rabbitmq-$name  rabbitmq:3-management

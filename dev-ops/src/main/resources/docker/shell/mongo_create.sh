#! /bin/bash
name=$1
port=$2
docker run --restart=always  --name mongo-$name -v /data/docker/mongo/data:/data/db -p0.0.0.0:$port:27017 -d mongo --storageEngine wiredTiger
docker run  -d --restart=always  --name mongo-express  --link mongo-dev:mongo  -p0.0.0.0:8081:8081   mongo-express

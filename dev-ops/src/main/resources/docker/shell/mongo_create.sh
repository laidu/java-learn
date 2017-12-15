#! /bin/bash
name=$1
port=$2
docker run --restart=always  --name mongo-$name -p0.0.0.0:$port:27017 -d mongo --storageEngine wiredTiger
docker run  -d --rm --restart=always  --name mongo-express  --link mongo-dev:mongo  -p0.0.0.0:8081:8081   mongo-express

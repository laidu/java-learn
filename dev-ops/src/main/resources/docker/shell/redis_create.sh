#! /bin/bash
name=$1
port=$2
docker run  --restart=always --name redis-$name -p 0.0.0.0:$port:6379 -d redis --appendonly yes

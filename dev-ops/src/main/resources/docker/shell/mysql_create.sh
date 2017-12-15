#! /bin/bash
name=$1
port=$2
mysql_root=/data/docker/mysql
docker run  -d --restart=always \
	--name mysql-${name} \
	-e MYSQL_ROOT_PASSWORD=root \
	-p 0.0.0.0:${port}:3306 \
	-v ${mysql_root}/conf.d:/etc/mysql/conf.d \
	-v ${mysql_root}/data:/var/lib/mysql \
	-v /etc/hosts:/etc/hosts  \
	mysql \

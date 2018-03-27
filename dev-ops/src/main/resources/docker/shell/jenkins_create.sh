#! /bin/bash
jenkin_root=/data/jenkins
name=$1
web_port=$2
port=$3
docker run  -d --restart=always \
    --name jenkins-${name} \
    -p ${web_port}:8080 \
    -p ${port}:50000 \
    -v ${jenkin_root}/jenkins_home:/var/jenkins_home \
    -v /etc/hosts:/etc/hosts  \
    -u root jenkins


docker run  -d --restart=always \
    --name jenkins-prod \
    -p 80:8080 \
    -p 5000:50000 \
    -v /data/jenkins/jenkins_home:/var/jenkins_home \
    -v /etc/hosts:/etc/hosts  \
    -u root jenkins
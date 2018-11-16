# This Dockerfile uses the centos7 image
# VERSION 2 - EDITION 1
# Author: laidu
# Command format: Instruction [arguments / command] ..

# Base image to use, this must be set as the first line
FROM centos:7.5.1804

# Maintainer: docker_user <docker_user at email.com> (@docker_user)
MAINTAINER laidu laidu823@gmail.com

# Commands to update the image
# Set aliyun mirror

# time zone
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN yum -y update; yum clean all
RUN yum -y install openssh-server passwd; yum clean all
ADD ./start.sh /start.sh
RUN mkdir /var/run/sshd

RUN ssh-keygen -t rsa -f /etc/ssh/ssh_host_rsa_key -N ''

RUN chmod 755 /start.sh
# EXPOSE 22
RUN ./start.sh
ENTRYPOINT ["/usr/sbin/sshd", "-D"]
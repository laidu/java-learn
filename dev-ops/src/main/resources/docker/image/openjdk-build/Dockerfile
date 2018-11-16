# This Dockerfile uses the centos7 image
# VERSION 2 - EDITION 1
# Author: laidu
# Command format: Instruction [arguments / command] ..

# Base image to use, this must be set as the first line
FROM daocloud.io/laidu/centos7-ssh:master

# Maintainer: docker_user <docker_user at email.com> (@docker_user)
MAINTAINER laidu laidu823@gmail.com

# Commands to update the image
# Set aliyun mirror

RUN yum -y update; yum clean all
RUN yum -y install openssh-server passwd; yum clean all
RUN yum -y groupinstall "Development Tools"; yum clean all
RUN yum -y install which libXtst-devel libXt-devel libXrender-devel \
    cups-devel freetype-devel alsa-lib-devel; yum clean all
RUN yum -y install java-1.7.0-openjdk-devel;  yum clean all

ENTRYPOINT ["/usr/sbin/sshd", "-D"]
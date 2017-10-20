# This dockerfile uses the ubuntu image
# VERSION 2 - EDITION 1
# Author: docker_user
# Command format: Instruction [arguments / command] ..

# Base image to use, this must be set as the first line
FROM ubuntu:16.04

# Maintainer: docker_user <docker_user at email.com> (@docker_user)
MAINTAINER laidu laidu823@email.com

# Default to UTF-8 file.encoding
ENV TZ "Asia/Shanghai"
ENV LANG en_US.UTF-8
ENV LC_ALL en_US.UTF-8

# Commands to update the image
# Set aliyun mirror & upgrade
RUN apt update && apt upgrade -y

# install jdk 8
RUN apt install wget -y
RUN wget --no-check-certificate -c \
    --header "Cookie: oraclelicense=accept-securebackup-cookie" \
    http://download.oracle.com/otn-pub/java/jdk/8u151-b12/e758a0de34e24606bca991d704f6dcbf/jdk-8u151-linux-x64.tar.gz && \
    tar -xvf jdk-8u151-linux-x64.tar.gz -C /opt/
ENV JAVA_HOME /opt/jdk1.8.0_151
RUN echo "export JAVA_HOME=$JAVA_HOME" >> ~/.bashrc
ENV CLASSPATH .:$JAVA_HOME/lib:$JAVA_HOME/jre/lib
RUN echo "export CLASSPATH=.:$JAVA_HOME/lib:$JAVA_HOME/jre/lib" >> ~/.bashrc
ENV PATH $JAVA_HOME/bin:$PATH
RUN echo "export PATH=$PATH" >> ~/.bashrc

# create data dir
RUN mkdir -p /data/upload
RUN mkdir -p /data/shell
RUN mkdir -p /data/software

RUN java -version
RUN javac -version


# Commands when creating a new container


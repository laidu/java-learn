# This dockerfile uses the ubuntu image
# VERSION 2 - EDITION 1
# Author: docker_user
# Command format: Instruction [arguments / command] ..

# Base image to use, this must be set as the first line
FROM ubuntu:16.04

# Maintainer: docker_user <docker_user at email.com> (@docker_user)
MAINTAINER laidu laidu823@email.com

# Default to UTF-8 file.encoding
ENV LANG C.UTF-8

# Commands to update the image
# Set aliyun mirror & upgrade
RUN apt update && apt upgrade -y

# install jdk 8
RUN echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections
RUN echo debconf shared/accepted-oracle-license-v1-1 seen true | debconf-set-selections

RUN apt-get update && \
    apt-get install -y --no-install-recommends software-properties-common && \
    add-apt-repository ppa:webupd8team/java && \
    apt-get update && \
    apt-get install -y --no-install-recommends oracle-java8-installer && \
    rm -rf /var/lib/apt/lists/*

# create data dir
RUN mkdir -p /data/upload
RUN mkdir -p /data/shell
RUN mkdir -p /data/software


# Commands when creating a new container


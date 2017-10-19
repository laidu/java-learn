# This dockerfile uses the ubuntu image
# VERSION 2 - EDITION 1
# Author: docker_user
# Command format: Instruction [arguments / command] ..

# Base image to use, this must be set as the first line
FROM ubuntu:16.04

# Maintainer: docker_user <docker_user at email.com> (@docker_user)
MAINTAINER laidu laidu823@email.com

# Commands to update the image
# Set aliyun mirror

RUN echo "" > /etc/apt/sources.list
RUN apt update && apt upgrade -y

# Commands when creating a new container
CMD /usr/sbin/nginx
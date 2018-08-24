# This Dockerfile uses the ubuntu image
# VERSION 2 - EDITION 1
# Author: docker_user
# Command format: Instruction [arguments / command] ..

# Base image to use, this must be set as the first line
FROM ubuntu:latest

# Maintainer: docker_user <docker_user at email.com> (@docker_user)
MAINTAINER laidu laidu823@gmail.com

# Commands to update the image
# Set aliyun mirror

# time zone
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
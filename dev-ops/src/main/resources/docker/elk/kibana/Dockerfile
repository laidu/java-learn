# This dockerfile uses the kibana:6.2.2 image
# VERSION 1 - EDITION 1
# Author: laidu

FROM docker.elastic.co/kibana/kibana:6.2.2

USER root
# time zone
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

MAINTAINER laidu laidu823@gmail.com
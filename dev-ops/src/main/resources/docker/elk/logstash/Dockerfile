# This dockerfile uses the logstash:6.2.2 image
# VERSION 1 - EDITION 1
# Author: laidu

FROM docker.elastic.co/logstash/logstash:6.2.2

# time zone
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

MAINTAINER laidu laidu823@gamil.com
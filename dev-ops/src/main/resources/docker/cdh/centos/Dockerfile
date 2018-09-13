# This Dockerfile uses the elasticsearch-platinum:6.2.2 image
# VERSION 1 - EDITION 1
# Author: laidu

FROM centos:7

MAINTAINER laidu laidu823@gmail.com

USER root

# time zone
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone


# Define working directory.
WORKDIR /data

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

# Define default command.
CMD ["bash"]

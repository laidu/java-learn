# This dockerfile uses the elasticsearch-platinum:6.2.2 image
# VERSION 1 - EDITION 1
# Author: laidu

FROM docker.elastic.co/elasticsearch/elasticsearch-platinum:6.2.2

MAINTAINER laidu laidu823@gmail.com

# overwrite office x-pack-core-6.2.2.jar by x-pack-core-6.2.2.jar crack
COPY dev-ops/src/main/resources/docker/elk/elasticsearch/crack/x-pack-core-6.2.2.jar crack/x-pack-core-6.2.2.jar /usr/share/elasticsearch/plugins/x-pack/x-pack-core/
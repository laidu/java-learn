# This dockerfile uses the elasticsearch-platinum:6.2.2 image
# VERSION 1 - EDITION 1
# Author: laidu

FROM docker.elastic.co/elasticsearch/elasticsearch-platinum:6.2.2

MAINTAINER laidu laidu823@gmail.com

# overwrite office x-pack-core-6.2.2.jar.crack by x-pack-core-6.2.2.jar.crack
COPY crack/x-pack-core-6.2.2.jar.crack /usr/share/elasticsearch/plugins/x-pack/x-pack-core/
CMD mv /usr/share/elasticsearch/plugins/x-pack/x-pack-core/x-pack-core-6.2.2.jar.crack /usr/share/elasticsearch/plugins/x-pack/x-pack-core/x-pack-core-6.2.2.jar
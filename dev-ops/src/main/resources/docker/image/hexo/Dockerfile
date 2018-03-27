# Hexo Dockerfile

# Pull base image.
FROM ubuntu:14.04
MAINTAINER xpcoder <xpcoder823@gmail.com>

# Install git and nodejs
RUN apt-get update && \
    apt-get install -y git-core nodejs npm

RUN ln -s /usr/bin/nodejs /usr/bin/node

# Install Hexo
RUN npm install -g hexo
RUN npm install hexo-migrator-wordpress --save
RUN npm install hexo-generator-feed --save
RUN npm install hexo-renderer-marked --save
RUN npm install hexo-generator-search --save
RUN npm install hexo-autonofollow --save
RUN npm install hexo-generator-sitemap --save
RUN npm install hexo-generator-json-content --save
RUN npm install hexo-wordcount --save
RUN npm install hexo-generator-restful --save
RUN npm install hexo-renderer-marked --save
RUN npm install hexo-renderer-stylus --save

# add non-root user
#RUN groupadd hexo && useradd -m -g hexo hexo
# replace gid and uid with your currently $GID and $UID
RUN useradd -m -g 100 -u 1000 hexo

ENV HOME /home/hexo

# Mount a Host Directory as a Data Volume for hexo
VOLUME /blog

# Expose ports.
EXPOSE 4000

WORKDIR /blog

#ENTRYPOINT ["hexo"]

USER hexo
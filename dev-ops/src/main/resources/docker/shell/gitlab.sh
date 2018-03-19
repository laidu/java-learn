#!/usr/bin/env bash

# "/etc/gitlab", "/var/opt/gitlab", "/var/log/gitlab"
docker run -d --name gitlab \
    -p 0.0.0.0:80:80 \
    -p 0.0.0.0:443:443 \
    -p 0.0.0.0:22:22 \
    -v /Users/laidu/temp/gitlab-etc:/etc/gitlab \
    -v /Users/laidu/temp/gitlab-opt:/var/opt/gitlab \
    -v /Users/laidu/temp/gitlab-var:/var/log/gitlab \
    gitlab/gitlab-ce
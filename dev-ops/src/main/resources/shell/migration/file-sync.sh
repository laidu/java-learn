#!/usr/bin/env bash

#   Function : 同步服务器间递归同步指定目录文件－－client
#   client : local pull files from source
#   server : local push files to source
#
#   Require :
#            1、ssh sshpass rsync
#            2、target can login source by ssh
#   Usage :
#            1. sh file-sync.sh  xx.xx.xx.xx remote_path local_path


source_ip=$1
source_path= $2
source_username='ubuntu'
source_password=

#target_ip=
local_path=$3
#local_username='ubuntu'
#local_password=

sync_cmd="sshpass -p ${source_password} rsync -auvrtzopgP ${source_username}@${source_ip}:${source_path} ${local_path}"

echo ${sync_cmd}

if [ ! -e ${local_path} ]; then
    echo "${local_path} is not exist, creating dir..."
    mkdir -p ${local_path}
    echo "${local_path} created"
fi

nohup ${sync_cmd} >> nohup.log 2>&1 &
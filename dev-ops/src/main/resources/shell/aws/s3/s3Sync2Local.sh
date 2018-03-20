#!/usr/bin/env bash

#   Function : sync s3 to local dir
#
#   Require :
#        ~/.aws awscli
#   Usage :
#            1.
#            2.

local_dir="/data/s3"
s3_bucjets="o2o"

if [-d ${local_dir}]; then
    mkdir -p ${local_dir}
fi

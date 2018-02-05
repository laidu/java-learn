#!/bin/bash
    
#   function :
#        统计文本中指定列的重复情况
#    require :
#         linux
#    usage :
#            1. 
#            2. 

dir="/Users/tczang/temp/"

for file in ${dir}/*; do
    if test -f ${file} ; then
        fileName=`basename ${file}`
        echo ${fileName}
        cat ${dir}${fileName} | awk '{print $1}' | sort | uniq -cd >> result
    fi
done
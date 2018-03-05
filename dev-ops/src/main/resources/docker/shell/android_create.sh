#! /bin/bash
name=$1
web_port=$2
port=$3
docker run -d  --restart=always -p0.0.0.0:5555:5555 -p0.0.0.0:5000:5000 -e "ARCH=armeabi-v7a" --name android-armeabi tracer0tong/android-emulator

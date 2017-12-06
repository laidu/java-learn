#! /bin/bash
name=$1
port=$2

docker run -d  --restart=always -p5555:5555 -p0.0.0.0:5000:5000 -e "ARCH=armeabi-v7a" --name android-armeabi tracer0tong/android-emulator
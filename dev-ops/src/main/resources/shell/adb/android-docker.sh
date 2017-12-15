#!/usr/bin/env bash

#   Function : ${FUNCTION}
# android emulator 通过 adb  联网
#
#   Require :
#        ${REQUIRE}
#   Usage :
#            1. 
#            2.

sudo socat tcp-listen:8081,bind=0.0.0.0,fork tcp:127.0.0.1:8080

adb forward tcp:8080 tcp:8080
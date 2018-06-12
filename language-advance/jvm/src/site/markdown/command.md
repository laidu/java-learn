# HotSpot 虚拟机命令行工具使用
> jdk1.8.0_172

## 0、概述

## 0.1、标准的JDK工具和实用程序

* 基本工具：
    appletviewer，extcheck，jar，java，javac，javadoc，javah，[javap]()，jdb，jdeps
* 安全工具：
    keytool，jarsigner，policytool，kinit，klist，ktab
* 国际化工具：native2ascii
* 远程方法调用（RMI）工具：
    rmic，rmiregistry，rmid，serialver
* Java IDL和RMI-IIOP工具：
    tnameserv，idlj，orbd，servertool
* Java部署工具：
    javapackager，pack200，unpack200
* Java Web Start工具：
    javaws
* Java故障排除，分析，监控和管理工具：
    jcmd，[jconsole]()，jmc，[jvisualvm]()
* Java Web服务工具：
    schemagen，wsgen，wsimport，xjc
    
## 0.2、实验JDK工具和实用程序
> 注 - 本节中描述的工具本质上不受支持并且是实验性的，应该考虑到这一点。它们可能在未来的JDK版本中不可用。

* 监视工具：
    * [jps]()
    * [jstat]()
    * [statd]()
* 疑难解答工具：
    * [jinfo]()
    * [jhat]()
    * [jmap]()
    * [jsadebugd]()
    * [jstack]()
* 脚本工具：
    jrunscript

* __[jps](#1、jps)__ 查看java进程
* __[jstat]()__ 内存相关
* __[jstack]()__ 线程相关
* __[jmap]()__ dump


## 1、jps

### 1.1 帮助文档
```bash
usage: jps [-help]
       jps [-q] [-mlvV] [<hostid>]

Definitions:
    <hostid>:      <hostname>[:<port>]
```

### 1.2 参数说明


参考：
* [javase-8-docs-tools](https://docs.oracle.com/javase/8/docs/technotes/tools/)
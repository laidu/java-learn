# dstat 命令使用

## 1 简介
> [HAProxy](http://www.haproxy.org/) 是一个使用C语言编写的自由及开放源代码软件，其提供高可用性、负载均衡，以及基于TCP和HTTP的应用程序代理。
* 提供高可用性、负载均衡以及基于TCP和HTTP应用的代理，支持虚拟主机，它是免费、快速并且可靠的一种解决方案。根据官方数据，其最高极限支持10G的并发。
* HAProxy特别适用于那些负载特大的web站点，这些站点通常又需要会话保持或七层处理。HAProxy运行在当前的硬件上，完全可以支持数以万计的并发连接。并且它的运行模式使得它可以很简单安全的整合进您当前的架构中， 同时可以保护你的web服务器不被暴露到网络上。<br/>
* HAProxy实现了一种事件驱动, 单一进程模型，此模型支持非常大的并发连接数。多进程或多线程模型受内存限制 、系统调度器限制以及无处不在的锁限制，很少能处理数千并发连接。事件驱动模型因为在有更好的资源和时间管理的用户空间(User-Space) 实现所有这些任务，所以没有这些问题。此模型的弊端是，在多核系统上，这些程序通常扩展性较差。这就是为什么他们必须进行优化以 使每个CPU时间片(Cycle)做更多的工作。
* Haproxy 并不是 Http 服务器。Nginx，ApacheProxy，lighttpd，Cheroke 等带反向代理均衡负载的产品，都清一色是 WEB 服务器。简单说，就是他们能自个儿提供静态(html,jpg,gif..)或动态(php,cgi..)文件的传输以及处理。而Haproxy 仅仅，而且专门是一款的用于均衡负载的应用代理。其自身并不能提供http服务。 

## 2 功能

## 3 安装
### 配置
```bash
global               #全局设置
    log 127.0.0.1   local0   #日志输出配置，所有日志都记录在本机，通过local0输出
    #log loghost    local0 info
    maxconn 4096             #最大连接数
    chroot /usr/local/haproxy
    uid 99                   #所属运行的用户uid
    gid 99                   #所属运行的用户组
    group haproxy            #用户组
    daemon                   #后台运行haproxy
    nbproc 1                 #启动1个haproxy实例
    pidfile /usr/local/haproxy/haproxy.pid  #将所有进程PID写入pid文件
    #debug
    #quiet
 
defaults             #默认设置
    #log    global
    log     127.0.0.1       local3      #日志文件的输出定向
 
    #默认的模式:tcp|http|health
    mode   http         #所处理的类别,默认采用http模式
 
    option  httplog      #日志类别,采用http日志格式`
    option  dontlognull
    option  forwardfor   #将客户端真实ip加到HTTP Header中供后端服务器读取
    option  retries 3    #三次连接失败则认证服务器不可用
    option  httpclose    #每次请求完毕后主动关闭http通道,haproxy不支持keep-alive,只>能模拟这种模式的实现
    retries 3            #3次连接失败就认为服务器不可用，主要通过后面的check检查
    option  redispatch   #当serverid对应的服务器挂掉后，强制定向到其他健康服务器
    option  abortonclose #当服务器负载很高时，自动结束掉当前队列中处理比较久的链接
    maxconn 2000         #默认最大连接数
 
    timeout connect 5000  #连接超时时间
    timeout client  50000 #客户端连接超时时间
    timeout server  50000 #服务器端连接超时时间
 
    stats   enable
    stats   uri /haproxy-stats   #haproxy监控页面的访问地址
    stats   auth test:test123    #设置监控页面的用户和密码
    stats   hide-version         #隐藏统计页面的HAproxy版本信息
 
frontend http-in              #前台
    bind    *:81
    mode    http
    option  httplog
    log     global
    default_backend htmpool   #静态服务器池
 
backend htmpool               #后台
    balance leastconn         #负载均衡算法
    option  httpchk HEAD /index.html HTTP/1.0    #健康检查
    server  web1 192.168.2.10:80 cookie 1 weight 5 check inter 2000 rise 2 fall 3
    server  web2 192.168.2.11:80 cookie 2 weight 3 check inter 2000 rise 2 fall 3
    # web1/web2:自定义服务器别名
    # 192.168.2.10:80:服务器IP:Port
    # cookie 1/2:表示serverid
    # weight: 服务器权重，数字越大分配到的请求数越高
    # check: 接受定时健康检查 
    # inter 2000: 检查频率
    # rise 2: 两次检测正确认为服务器可用
    # fall 3: 三次失败认为服务器不可用
 
listen w.gdu.me 0.0.0.0:80
    option  httpchk GET /index.html
    server  s1 192.168.2.10:80 weight 3 check
    server  s3 192.168.2.11:80 weight 3 check
 
# Haproxy统计页面
# --------------------------------------------------------------------------------------------
listen haproxy_stats
    bind 0.0.0.0:1080  #侦听IP:Port
    mode http
    log  127.0.0.1 local 0 err #err|warning|info|debug]
    stats refresh 30s
    stats uri /haproxy-stats
    stats realm Haproxy\ Statistics
    stats auth admin:admin
    stats auth test:test
    stats hide-version
    stats admin if TRUE  #手工启用/禁用后端服务器
 
 
# 网站检测listen配置
# --------------------------------------------------------------------------------------------
listen site_status
    bind 0.0.0.0:1081
    mode http
    log  127.0.0.1 local0 err
 
    #网站健康检查URI，用来检测Haproxy管理的网站是否可能，正常返回200、异常返回500
    monitor-uri /site_status
 
    #定义网站down时的策略
    #当backend中的有效服务器数<1时，返回true
    acl site_dead nbsrv(denali_server) lt 1
    acl site_dead nbsrv(tm_server) lt 1
    acl site_dead nbsrv(mms_server) lt 1
 
    #当满足策略的时候返回http-500，否则返回http-200
    monitor fail if site_dead
 
    #声名一个监测请求的来源网络
    monitor-net 192.168.0.252/31
 
 
# https的配置方法
# --------------------------------------------------------------------------------------------
listen login_https_server
    bind 0.0.0.0:443   #绑定HTTPS的443端口
    mode tcp           #https必须使用tcp模式
    log global
    balance roundrobin
    option httpchk GET /member/login.jhtml HTTP/1.1\r\nHost:login.daily.taobao.net
    #回送给server的端口也必须是443
    server vm94f.sqa 192.168.212.94:443 check port 80 inter 6000 rise 3 fall 3
    server v215120.sqa 192.168.215.120:443 check port 80 inter 6000 rise 3 fall 3
 
 
# frontend配置
# --------------------------------------------------------------------------------------------
frontend http_80_in
    bind 0.0.0.0:80   #监听端口
    mode http         #http的7层模式
    log global        #使用全局的日志配置
    option httplog    #启用http的log
    option httpclose  #每次请求完毕后主动关闭http通道,HA-Proxy不支持keep-alive模式
    option forwardfor ##如果后端服务器需要获得客户端的真实IP需要配置次参数,将可以从Http Header中获得客户端IP
 
    #HAProxy的日志记录内容配置
    capture request header Host len 40              # 请求中的主机名
    capture request header Content-Length len 10    # 请求中的内容长度
    capture request header Referer len 200          # 请求中的引用地址
    capture response header Server len 40           # 响应中的server name
    capture response header Content-Length len 10   # 响应中的内容长度(可配合option logasap使用)
    capture response header Cache-Control len 8     # 响应中的cache控制
    capture response header Location len 20         # 响应中的重定向地址
 
 
    #ACL策略规则定义
    #-------------------------------------------------
    #如果请求的域名满足正则表达式返回true(-i:忽略大小写)
    acl denali_policy hdr_reg(host) -i ^(www.gemini.taobao.net|my.gemini.taobao.net|auction1.gemini.taobao.net)$
 
    #如果请求域名满足trade.gemini.taobao.net返回true
    acl tm_policy hdr_dom(host) -i trade.gemini.taobao.net
 
    #在请求url中包含sip_apiname=,则此控制策略返回true,否则为false
    acl invalid_req url_sub -i sip_apiname=
 
    #在请求url中存在timetask作为部分地址路径,则此控制策略返回true,否则返回false
    acl timetask_req url_dir -i timetask
 
    #当请求的header中Content-length等于0时返回true
    acl missing_cl hdr_cnt(Content-length) eq 0
 
 
    #ACL策略匹配相应
    #-------------------------------------------------
    #当请求中header中Content-length等于0阻止请求返回403
    #block表示阻止请求,返回403错误
    block if missing_cl
 
    #如果不满足策略invalid_req,或者满足策略timetask_req,则阻止请求
    block if !invalid_req || timetask_req
 
    #当满足denali_policy的策略时使用denali_server的backend
    use_backend denali_server if denali_policy
 
    #当满足tm_policy的策略时使用tm_server的backend
    use_backend tm_server if tm_policy
 
    #reqisetbe关键字定义,根据定义的关键字选择backend
    reqisetbe ^Host:\ img           dynamic
    reqisetbe ^[^\ ]*\ /(img|css)/  dynamic
    reqisetbe ^[^\ ]*\ /admin/stats stats
 
    #以上都不满足的时候使用默认mms_server的backend
    default_backend mms_server
 
    #HAProxy错误页面设置
    errorfile 400 /home/admin/haproxy/errorfiles/400.http
    errorfile 403 /home/admin/haproxy/errorfiles/403.http
    errorfile 408 /home/admin/haproxy/errorfiles/408.http
    errorfile 500 /home/admin/haproxy/errorfiles/500.http
    errorfile 502 /home/admin/haproxy/errorfiles/502.http
    errorfile 503 /home/admin/haproxy/errorfiles/503.http
    errorfile 504 /home/admin/haproxy/errorfiles/504.http
 
 
# backend的设置
# --------------------------------------------------------------------------------------------
backend mms_server
    mode http           #http的7层模式
    balance roundrobin  #负载均衡的方式,roundrobin平均方式
    cookie SERVERID     #允许插入serverid到cookie中,serverid后面可以定义
     
    #心跳检测的URL,HTTP/1.1¥r¥nHost:XXXX,指定了心跳检测HTTP的版本,XXX为检测时请求
    #服务器的request中的域名是什么,这个在应用的检测URL对应的功能有对域名依赖的话需要设置
    option httpchk GET /member/login.jhtml HTTP/1.1\r\nHost:member1.gemini.taobao.net
     
    #服务器定义,cookie 1表示serverid为1,check inter 1500 是检测心跳频率
    #rise 3是3次正确认为服务器可用,fall 3是3次失败认为服务器不可用,weight代表权重
    server mms1 10.1.5.134:80 cookie 1 check inter 1500 rise 3 fall 3 weight 1
    server mms2 10.1.6.118:80 cookie 2 check inter 1500 rise 3 fall 3 weight 2
 
 
backend denali_server
    mode http
    balance source     #负载均衡的方式,source根据客户端IP进行哈希的方式
    option allbackups  #设置了backup的时候,默认第一个backup会优先,设置option allbackups后所有备份服务器权重一样
 
    #心跳检测URL设置
    option httpchk GET /mytaobao/home/my_taobao.jhtml HTTP/1.1\r\nHost:my.gemini.taobao.net
 
    #可以根据机器的性能不同,指定连接数配置，如minconn 10 maxconn 20
    server denlai1 10.1.5.114:80 minconn 4 maxconn 12 check inter 1500 rise 3 fall 3
    server denlai2 10.1.6.104:80 minconn 10 maxconn 20 check inter 1500 rise 3 fall 3
    #备份机器配置,正常情况下备机不会使用,当主机的全部服务器都down的时候备机会启用
    server dnali-back1 10.1.7.114:80 check backup inter 1500 rise 3 fall 3
    server dnali-back2 10.1.7.114:80 check backup inter 1500 rise 3 fall 3
 
 
backend tm_server
    mode http
    balance leastconn   #负载均衡的方式,leastcon选择当前请求数最少的服务器
    option httpchk GET /trade/itemlist/prepayCard.htm HTTP/1.1\r\nHost:trade.gemini.taobao.net
    server tm1 10.1.5.115:80 check inter 1500 rise 3 fall 3
    server tm2 10.1.6.105:80 check inter 1500 rise 3 fall 3
 
 
#reqisetbe自定义关键字匹配backend部分
backend dynamic
    mode http
    balance source
    option httpchk GET /welcome.html HTTP/1.1\r\nHost:www.taobao.net
    server denlai1 10.3.5.114:80 check inter 1500 rise 3 fall 3
    server denlai2 10.4.6.104:80 check inter 1500 rise 3 fall 3
 
backend stats
    mode http
    balance source
    option httpchk GET /welcome.html HTTP/1.1\r\nHost:www.taobao.net
    server denlai1 10.5.5.114:80 check inter 1500 rise 3 fall 3
    server denlai2 10.6.6.104:80 check inter 1500 rise 3 fall 3
```

## 4 用法
### 4.1 基本用法

### 4.2 常用参数

### 4.3 常用插件

### 4.4 示例
参考：
* [HAProxy Starter Guide](http://cbonte.github.io/haproxy-dconv/1.8/intro.html)
* [百度百科](https://baike.baidu.com/item/haproxy/5825820?fr=aladdin)
* [haproxy配置范例](http://xstarcd.github.io/wiki/sysadmin/haproxy_confs.html)
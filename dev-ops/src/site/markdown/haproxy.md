# dstat 命令使用

## 1 简介
> [HAProxy](http://www.haproxy.org/) 是一个使用C语言编写的自由及开放源代码软件，其提供高可用性、负载均衡，以及基于TCP和HTTP的应用程序代理。
* 提供高可用性、负载均衡以及基于TCP和HTTP应用的代理，支持虚拟主机，它是免费、快速并且可靠的一种解决方案。根据官方数据，其最高极限支持10G的并发。
* HAProxy特别适用于那些负载特大的web站点，这些站点通常又需要会话保持或七层处理。HAProxy运行在当前的硬件上，完全可以支持数以万计的并发连接。并且它的运行模式使得它可以很简单安全的整合进您当前的架构中， 同时可以保护你的web服务器不被暴露到网络上。<br/>
* HAProxy实现了一种事件驱动, 单一进程模型，此模型支持非常大的并发连接数。多进程或多线程模型受内存限制 、系统调度器限制以及无处不在的锁限制，很少能处理数千并发连接。事件驱动模型因为在有更好的资源和时间管理的用户空间(User-Space) 实现所有这些任务，所以没有这些问题。此模型的弊端是，在多核系统上，这些程序通常扩展性较差。这就是为什么他们必须进行优化以 使每个CPU时间片(Cycle)做更多的工作。
* Haproxy 并不是 Http 服务器。Nginx，ApacheProxy，lighttpd，Cheroke 等带反向代理均衡负载的产品，都清一色是 WEB 服务器。简单说，就是他们能自个儿提供静态(html,jpg,gif..)或动态(php,cgi..)文件的传输以及处理。而Haproxy 仅仅，而且专门是一款的用于均衡负载的应用代理。其自身并不能提供http服务。 

## 2 功能

## 3 安装

## 4 用法
### 4.1 基本用法

### 4.2 常用参数

### 4.3 常用插件

### 4.4 示例
参考：
* [HAProxy Starter Guide](http://cbonte.github.io/haproxy-dconv/1.8/intro.html)
* [百度百科](https://baike.baidu.com/item/haproxy/5825820?fr=aladdin)
* [haproxy配置范例](http://xstarcd.github.io/wiki/sysadmin/haproxy_confs.html)
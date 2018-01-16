# linux cache

刷新缓存

```bash
sync; echo 1 > /proc/sys/vm/drop_caches # 仅清除页面缓存（PageCache）
sync; echo 2 > /proc/sys/vm/drop_caches # 清除目录项和inode
sync; echo 3 > /proc/sys/vm/drop_caches # 清除页面缓存，目录项和inode
```

参考:
* [在 Linux 上如何清除内存的 Cache、Buffer 和交换空间](https://linux.cn/article-5627-1.html)
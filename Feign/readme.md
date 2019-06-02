# Feign

### Feign具有如下特性：

- 可插拔的注解支持，包括Feign注解和JAX-RS注解;
- 支持可插拔的HTTP编码器和解码器;
- 支持Hystrix和它的Fallback;
- 支持Ribbon的负载均衡;
- 支持HTTP请求和响应的压缩。

利用Feign访问wordladder服务

本服务运行在8083端口，可以访问主页、登录页面和输入wordladder起始终止单词的页面

输入两个单词后点击提交按钮，会通过"/get_wordladder"访问另外启动的wordladder服务

### 参考资料

[SpringCloud实战1-Eureka](https://www.cnblogs.com/huangjuncong/p/9020474.html)

[SpringCloud实战5-Feign声明式服务调用](https://www.cnblogs.com/huangjuncong/p/9053576.html)

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

### 负载均衡

给FeignService接口添加注解```@FeignClient(value = "wordladder-service",fallback = FeignClientFallback.class)``` ，其中 value 定位了注册的名为 "wordladder-service" 服务，fallback是定义了熔断机制。

当注册了多个 "wordladder-service" 服务后，会轮流使用这几个服务

例如，复制了一份 wordladder 项目（wordladder-copy），在返回结果中加了" 111"，服务运行在9001端口，另一个wordladder运行在9000端口，然后在页面中查询wordladder时会轮流得到有" 111"的结果和正常的结果。

![](.\img\eureka.jpg)

调用服务1 ![service1](.\img\result0.jpg)

调用服务2![service2](.\img\result1.jpg)

### 参考资料

[SpringCloud实战1-Eureka](https://www.cnblogs.com/huangjuncong/p/9020474.html)

[SpringCloud实战5-Feign声明式服务调用](https://www.cnblogs.com/huangjuncong/p/9053576.html)

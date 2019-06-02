# Eureka

### Eureka具有如下特性：
- 1.服务注册
服务提供者启动时，会通过rest请求的方式将自己注册到Eureka Server上，同时带上了自身服务的一些元数据信息。Eureka Server接收到请求后，将元数据信息存储在一个双层结构的Map中，其中与第一层的key是服务名，第二层的key是具体的服务实例名
eureka.client.register-with-eureka=false 是否向注册中心注册自己 默认 true
eureka.client.fetch-registry=false 是否去检索注册中心的服务 默认 true


- 2.服务续约
在注册完服务后，服务提供者会维护一个心跳用来持续高速Eureka Server“我还活着”，以防止Eureka Server的“剔除任务”将该服务实例从服务列表中排除出去
eureka.instance.lease-renewal-interval-in-seconds=30 定义服务续约任务的调用间隔时间 默认30s
eureka.instance.lease-expiration-duration-in-seconds=90 定义服务失效的时间 默认90s


- 3.服务下线
当服务实例进行正常的关闭操作时，会触发一个服务下线的rest请求给Eureka Server ，告诉注册中心：”我要下线了“，服务端在接收请求后，将该服务置为下线（DOWN），并把下线时间传播出去（通知服务消费者）


本服务运行在3000端口,将Feign服务注册到Eureka上。
// Test merge.

### 参考资料

[SpringCloud实战1-Eureka](https://www.cnblogs.com/huangjuncong/p/9020474.html)
[SpringCloud学习1-服务注册与发现(Eureka) - Ryan.Miao - 博客园](https://www.cnblogs.com/woshimrf/p/springclout-eureka.html)

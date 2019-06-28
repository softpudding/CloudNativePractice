## Milestones Ⅲ　Spring Cloud实现

Spring Cloud基于Spring Boot，适合用于管理Spring Boot创建的各个微服务应用。

### Structure

#### 1 ServerConfig
Spring Cloud Config分为Config Server和Config Client两部分，为分布式系统外部化配置提供了支持,其能够结合Git的版本控制系统，帮助管理多个服务。<br>
其中Config Server是集中式、可扩展的配置服务器，可以集中管理应用程序各个环境下的配置，默认使用Git存储配置内容。<br>
Config Client是Config Server的客户端，用于操作存储在Config Server中的配置内容。<br>
更多关于本项目的Config配置请阅读： [Spring Cloud Config](ServerConfig/readme.md)

#### 2 Feign
Feign是声明式的Web Service客户端，目的是让Web Service调用更加简单。<br>
Feign提供了HTTP请求的模板，会完全代理HTTP请求，通过编写简单的接口和插入注解，可以定义HTTP请求的参数、格式、地址等信息。
，我们只需要像调用方法一样调用它就可以完成服务请求及相关处理。<br>
更多内容请阅读： [Feign](Feign/readme.md).

#### 3 Gateway
Gateway & Hystrix <br>
Spring Cloud Gateway默认集成了Redis限流，可以对不同服务做不同维度的限流，如：IP限流、用户限流 、接口限流.<br>
可以很大程度上提高服务的可用性与稳定性，其目的是通过对并发访问/请求,或对一个时间窗口内的请求进行限速来保护系统。

#### 4 wordladder:
Word Ladder主体所在文件夹.

#### 5 OAuth
OAuth协议为用户资源的授权提供了一个安全的、开放而又简易的标准。<br>
其特点有：
- 简单：不管是OAUTH服务提供者还是应用开发者，都很易于理解与使用；
- 安全：没有涉及到用户密钥等信息，更安全更灵活；
- 开放：任何服务提供商都可以实现OAUTH，任何软件开发商都可以使用OAUTH；

#### 6 Eureka
Eureka基于REST的服务，主要用于定位运行在AWS域中的中间层服务，以达到负载均衡和中间层服务故障转移的目的。<br>
Eureka Server提供服务注册服务，各个节点启动后，会在Eureka Server中进行注册，这样EurekaServer中的服务注册表中将会存储所有可用服务节点的信息，服务节点的信息可以在界面中直观的看到。<br>
Eureka Client是一个java客户端，用于简化与Eureka Server的交互，客户端同时也就是一个内置的、使用轮询(round-robin)负载算法的负载均衡器。

#### Implementation
运行ServerConfig，对接[配置文件](https://github.com/llIllIllIlllIll/SpringCloudConfig).<br>
各服务启动时自动从localhost:8888去获取配置文件。

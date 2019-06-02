## Milestones Ⅲ　Spring Cloud实现

Spring Cloud基于Spring Boot，适合用于管理Spring Boot创建的各个微服务应用。

#### Structure

##### 1 ServerConfig
Spring Cloud Config分为Config Server和Config Client两部分，为分布式系统外部化配置提供了支持,其能够结合Git的版本控制系统，帮助管理多个服务。<br>
其中Config Server是集中式、可扩展的配置服务器，可以集中管理应用程序各个环境下的配置，默认使用Git存储配置内容。<br>
Config Client是Config Server的客户端，用于操作存储在Config Server中的配置内容。<br>
更多关于本项目的Config配置请阅读： [Spring Cloud Config](ServerConfig/readme.md)

##### 2 Feign
Feign是声明式的Web Service客户端，目的是让Web Service调用更加简单。<br>
Feign提供了HTTP请求的模板，会完全代理HTTP请求，通过编写简单的接口和插入注解，可以定义HTTP请求的参数、格式、地址等信息。
，我们只需要像调用方法一样调用它就可以完成服务请求及相关处理。<br>
更多内容请阅读： [Feign](Feign/readme.md).

##### 3 Gateway
Gateway & Hystrix <br>
Spring Cloud Gateway默认集成了Redis限流，可以对不同服务做不同维度的限流，如：IP限流、用户限流 、接口限流.<br>
可以很大程度上提高服务的可用性与稳定性，其目的是通过对并发访问/请求,或对一个时间窗口内的请求进行限速来保护系统。

##### 4 wordladder:
Word Ladder主体所在文件夹.

#### Implementation
运行ServerConfig，对接[配置文件](https://github.com/llIllIllIlllIll/SpringCloudConfig).<br>
各服务启动时自动从localhost:8888去获取配置文件。

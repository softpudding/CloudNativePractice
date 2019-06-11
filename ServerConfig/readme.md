# Spring Cloud Config
### 概述
Spring cloud config在微服务的架构里起到了非常重要的作用。Spring Cloud Config结合Git的版本控制系统，帮助你管理多个服务。
### 我们的Config Server
目前我们的配置文件仓库在 [Spring Cloud Config files](https://github.com/llIllIllIlllIll/SpringCloudConfig),当前管理了Gateway、Wordladder、Feign三个模块的配置。
Config Server跑起来之后在8888端口。
### 我们的Config Client
Gateway、Word Ladder、Feign都配置了Config Client。启动时会自动从localhost:8080去获取自己的配置文件。
跑起来的时候输出就这样：
```sh
2019-06-02 13:39:20.705  INFO 9096 --- [           main] c.c.c.ConfigServicePropertySourceLocator : Fetching config from server at : http://localhost:8888/
2019-06-02 13:39:23.477  INFO 9096 --- [           main] c.c.c.ConfigServicePropertySourceLocator : Located environment: name=wordladder, profiles=[dev], label=master, version=f036d0fe093c08cd1afd2ec2cb9e89f2a936b2ce, state=null
2019-06-02 13:39:23.478  INFO 9096 --- [           main] b.c.PropertySourceBootstrapConfiguration : Located property source: CompositePropertySource {name='configService', propertySources=[MapPropertySource {name='configClient'}, MapPropertySource {name='https://github.com/llIllIllIlllIll/SpringCloudConfig/wordladder-dev.properties'}]}
```
### 单元测试
用mockmvc进行了测试，并且更新了.drone.yml，增加了新的CI环节。

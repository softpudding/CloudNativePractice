# Docker Compose

### 项目打包

```mvn clean package```

打包前修改项目中的一些内容

+ 把项目中的URL改为 http://192.168.99.100:port/
+ 其中OAuth有关的部分新创建了一个 Authorized OAuth App, 将OAuth和Feign中有关的URL,Clientid, Clientsecret做了修改
+ 修改了wordladder中字典读文件的方法，原来直接写路径的方法在打包后不能正确读到文件

### Dockerfile

给每个项目写对应的 Dockerfile

### docker-compose.yml

将每个项目建成一个镜像，然后分别运行在一个container中。

其中OAuth的启动需要依赖ServerConfig，即在ServerConfig正常启动以后，OAuth才能够启动。
但是docker compose在启动服务时没有先后顺序，所以用了一个比较简单但是效率不是特别好的方法，让OAuth在没有成功启动之后一直重启，知道能够成功启动。

``` docker
oauth:
    build: ./OAuth
    ports:
      - "9002:9002"
    depends_on:
      - config
    restart:
      always
```

之后只需要
```docker-compose up```
一条命令就可以将所有服务同时启动

服务运行后访问URL如下

+ HOME [http://192.168.99.100:8080](http://192.168.99.100:8080)
+ Eureka [http://192.168.99.100:3000](http://192.168.99.100:3000)
+ 其他端口号参考docker-compose.yml文件

关于docker compose的详细内容参考
[Get started with Docker Compose](https://docs.docker.com/compose/gettingstarted/)

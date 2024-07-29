# SpringCloud Alibaba配置步骤
## 1. 创建SpringBoot项目（3.0.2）
作为父项目不需要src源码，只需要使用pom管理包。

在pom中添加如下内容实现依赖版本管理（分别是SpringCloud基础依赖管理和SpringCloudAlibaba依赖管理），该项目的子项目的依赖不需要再指定版本。[版本参照](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)
``` xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-alibaba-dependencies</artifactId>
            <version>2022.0.0.0-RC2</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>2022.0.0</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```
## 2. 创建子项目（微服务）
子项目创建为Maven项目，并向pom里添加基础依赖（spring web,alibaba nacos-discovery,loadbalancer），不需要指定版本，因为父项目已经有了这几个包的版本管理
``` xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-loadbalancer</artifactId>
    </dependency>
</dependencies>
```
## 3. 配置nacos
每一个微服务（子项目）都需要配置application.yml，目的是和nacos建立连接，实现服务自动注册
``` yml
server:
  port: 8080  # 服务端口
spring:
  application:
    name: order-s  # 服务名，和nacos上的对应
  cloud:
    nacos:
      server-addr: 127.0.0.1:8848  # nacos服务地址
      discovery:
        username: nacos  # nacos登陆使用
        password: nacos
        namespace: public  # nacos默认namespace
```
# 项目运行
运行order和stock（可以运行多个不同端口查看负载均衡情况）访问：[http://localhost:8080/add](http://localhost:8080/add)，可以看到order服务通过nacos调用了stock服务

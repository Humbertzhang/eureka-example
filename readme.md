# Steps 

## 1. build

```shell
cd eureka-consumer 
mvn clean package

cd eureka-provider
mvn clean package

cd eureka-servicecenter
mvn clean package
```

如果下载速度过慢或失败，尝试使用maven代理。具体配置教程：[Maven 公共代理库](https://developer.aliyun.com/article/754038)

## 2. start 

```shell
# 先启动 eureka server
cd eureka-servicecenter
java -jar target/servicecenter-0.0.1-SNAPSHOT.jar

# 再启动consumer与provider
cd eureka-provider
java -jar target/server-0.0.1-SNAPSHOT.jar 

cd eureka-consumer 
java -jar target/client-0.0.1-SNAPSHOT.jar
```

## 3. request
尝试在浏览器中访问client提供的API.
如 `http://localhost:6783/hi?name=test`

## 4. observe

* 观察consumer与provider的源代码，弄清他们之间是如何交互的。

* 观察 eureka 页面 `http://localhost:6781`。
  尝试停止某个服务，或使用 `java -jar target/server-0.0.1-SNAPSHOT.jar --server.port=xxxx` 来启动多个server服务后，再次观察该页面，查看具体变化。
  注意需要使用 `--server.port=xxxx` 来避免端口占用冲突。


# fx-http-client
用javaFX实现的简单http客户端，类似postman，但是只有最基本的功能，如下：

- 发送get/post请求
- 发送json格式的get/post请求
- 展示请求头、请求体、响应头、响应体等
- 格式化json
- 可忽略证书校验，方便验证使用自签名证书的站点
- 使用H2保留历史记录

## 适用对象

仅需简单的测试接口测试功能，postman无法使用或无法安装的情况下可作为替代

## 前置条件

- 需要有javaFX运行环境，windows版jdk1.8自带JavaFX，可直接运行。但openJDK以及jdk9+默认不包含
JavaFX运行环境，需要手动安装

## 使用方法

1. 下载generated下fx-http-client.jar直接运行
2. 使用源码在IDE中运行，或用IDE编译到处可执行jar

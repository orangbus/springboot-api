# 说明
此项目是一个基于springboot的段子视频接口项目。

## 运行环境：
> jdk:11
> 
> mysql:8.0
> 
> docker20.x
> 
> docker-compose:2.x

## 数据库配置文件
```text
./src/main/resources/application.yaml
```
默认数据库名：`java_video` 

## 运行项目
### 下载源码
```bash
git clone 
```
推荐使用idea导入项目，下载相关依赖，build项目生成jar包
### 启用项目
```bash
docker-compose up -d app
```
## 数据库管理
```bash
docker-compose up -d phpmyadmin
```
访问地址：ip+8081

导入sql文件：qq群:511300462

# 重新打包编译注意事项
如果打包编译出来的 `project.jar` 的名字不是`video-0.0.1-SNAPSHOT.jar`,请修改`dockerfile` 打包后项目的名字
```dockerfile
ADD ./target/video-0.0.1-SNAPSHOT.jar /Code
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Code/video-0.0.1-SNAPSHOT.jar"]
```
重新编译项目,再运行项目
```bash
docker-compose build app
```
FROM java:8
LABEL maintainer="orangbus40400@gmail.com"

WORKDIR /Code
# 本地测试
ADD ./target/video-0.0.1-SNAPSHOT.jar /Code
# 线上运行
#ADD ./prod/video-0.0.1-SNAPSHOT.jar /Code
EXPOSE 8080
# 项目启用命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Code/video-0.0.1-SNAPSHOT.jar"]
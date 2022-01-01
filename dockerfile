#FROM java:8
# 根据容器限制自动计算堆的值,Fabric8社区提供的基础Docker镜像,用50％的可用内存作为上限

FROM 私服仓库地址

VOLUME /tmp

VOLUME /logs

# 参数设置
ARG JAR_FILE
ARG SERVER_PORT
ARG SERT_PATH

## 拷贝文件内容
#ADD $JAR_FILE /app.jar
ADD target/xiao-*.jar /app.jar

## 开放端口
EXPOSE ${SERVER_PORT}

# 环境变量
ENV JVM_OPTS="-Xmx2g -Xms2g -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:+PrintFlagsFinal -XX:+PrintGCDetails"

## 容器启动后第一个命令
#CMD java -server $JVM_UNLOCK $JVM_OPTS -jar /lottery-server.jar
ENTRYPOINT ["java","-server","-Dfile.encoding=UTF-8","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


## jar -- dockerfile
#FROM hub.c.163.com/library/java:latest
#EXPOSE 8080
#VOLUME /tmp
#ADD mall-0.0.1-SNAPSHOT.jar app.jar
#RUN sh -c 'touch /app.jar'
#ENV JAVA_OPTS=""
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

## war -- dockerfile
FROM hub.c.163.com/library/tomcat:latest
MAINTAINER simon
#这个环境变量用来表名该镜像模板的最后更新时间
ENV REFRESHED_AT 2019-10-11
#将宿主机当前目录下的war包拷至镜像的/usr/tomcat/webapps目录下
ADD mall-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps
#暴露端口
EXPOSE 8080
#设置启动命令
CMD ["/usr/local/tomcat/bin/catalina.sh","run"]
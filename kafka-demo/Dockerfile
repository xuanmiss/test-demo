FROM java:8
VOLUME /tmp
ADD target/kafka-demo-1.0.jar /app.jar
ENV TZ Asia/Shanghai
RUN bash -c 'touch /app.jar'
EXPOSE 9012
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
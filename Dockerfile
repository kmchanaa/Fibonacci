# syntax=docker/dockerfile:1
FROM openjdk:16-alpine3.13

COPY config.yml /data/fibonacci/config.yml
COPY /target/fibonacci-0.0.1-SNAPSHOT.jar /data/fibonacci/fibonacci-0.0.1-SNAPSHOT.jar

WORKDIR /data/fibonacci

RUN java -version

CMD ["java","-jar","fibonacci-0.0.1-SNAPSHOT.jar","server","config.yml"]

EXPOSE 8080
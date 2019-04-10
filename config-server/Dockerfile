FROM openjdk:8-jdk-alpine

MAINTAINER "nithinganji"

WORKDIR /usr/bin/local

EXPOSE 8888

COPY /target/*.jar config.jar

CMD ["java","-jar","config.jar"] 

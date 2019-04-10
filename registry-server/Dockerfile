FROM openjdk:8-jdk-alpine

MAINTAINER "nithinganji"

WORKDIR /usr/bin/local

EXPOSE 8761

COPY /target/*.jar registry.jar

CMD ["java","-jar","registry.jar"] 

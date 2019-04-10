FROM openjdk:8-jdk-alpine

MAINTAINER "nithinganji"

WORKDIR /usr/bin/local

EXPOSE 4200

COPY /target/*.jar ui.jar

CMD ["java","-jar","ui.jar"] 

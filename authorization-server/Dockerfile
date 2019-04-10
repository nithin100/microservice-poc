FROM openjdk:8-jdk-alpine

MAINTAINER "nithinganji"

WORKDIR /usr/bin/local

EXPOSE 5000

COPY /target/*.jar auth.jar

CMD ["java","-jar","auth.jar"] 

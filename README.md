**This repository can now be containerized. Click [here](https://github.com/nithin100/microservice-poc/blob/master/Dockerization-README.md) to learn about it.**

# microservice-poc

Microserives are the new trend in the Web development world. There are plenty of projects that are currently migrating to Microservices. 
This is a sample repository of a microservice architecture. Most of the microservices components like Registry server, Config server, Authorization server are used for this application.

There are five services in the repository each serving a unique purpose.

*******
authorization-server: This service/server is responsible for validating and generating authorization tokens. Oauth2+JWT is used for serving authorization.
spring-security-oauth is used for Oauth2 authorization. In memory userservice is used for getting user details like username,password and roles.

*******
config-server: This service/server is responsible for providing configurations to all the other services. This is one of the important component for cloud native applications. Embedding config within the application is not a great idea when it comes to cloud native application because of its ability to change continuously. 
spring-cloud-config-server is used for serving this purpose. The configuration is a native profiled that is all the configurations are embedded inside config-server. This however can be changed to a third party location like github (spring does provide integrating git repository for getting configs from). We can also have multiple locations however only one can be used based on the profile the service is running in. native profile is used in this case.

*******
registry-server: This service/server is responsible for registration of all microservices so that they can easily be discoverable by other microservices. This is a very important concept in microservice architecture, because microservices are modular in nature there might be some kind of communication between them. Hence they need to know each other and feeding the location directly is not a good practice because microservices are immutable. That is where registry server comes into action. This server enables the communication via names of the microservices rather than direct physical location i.e., host and port.
pring-cloud-starter-netflix-eureka-server is used for serving this purpose. This is a spring implementation of Netflix Eureka registry.

*******
poc-ui: This service/server is responsible rendering ui and also acts as proxy server. All the requests from front end are proxied to individual services by this service.
spring-cloud-starter-netflix-zuul is used for serving this purpose.

*******
addition-service: A sample microservice which takes in two integers and return their sum.

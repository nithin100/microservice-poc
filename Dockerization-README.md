To Dockerize entire architecture there are Dockerfiles in each module that are used for creating images and ultimately for running containers. Now these are definitely not production grade and need lot of changes in the code to make them fully scalable. There are still static ports for each of these modules and will be changed very soon. 

These dependenices are only there because I didn't have enough time to change these. This repository is purely for helping others understand how to dockerize a Java based microservices architecture.

# Instructions on using Dockerfiles

Each module has its own Dockerfile and each of them are used for creating Docker images. These Dockerfiles use alpine version of jdk-8 and provide Java runtime for packaged jars.

You need to compile and package each module using maven commands before creating docker images. One important thing to observe here is to skip tests when doing compilation. This is because bootstra.yml in each module has some static image names in them. The reason is explained below. Because of this static binding we cannot run tests. We can for sure remove these static bindings but that is for later. 

#### Skip tests: 

use **mvn install -Dmaven.test.skip=true**

## Creating Docker images

Once this is done run just simply run Docker command for creating image

use **docker build -t Name .** from a module's root directory

## Skip Creating Docker images

You can now skip creating images as I have made these images available on DockerHub

Find these images [here](https://hub.docker.com/u/nithinganji)

## Creating Docker network

Every Docker container run on its own private network and are not visible to each other. This is a problem when it comes to microservices architecture. Reasons? [find in here](https://www.nginx.com/blog/service-discovery-in-a-microservices-architecture/)

use **docker create network --driver bridge network-name**

## Running containers

Once you are finished with creating all images now its time to run these images as containers

use **docker run --network network-name --name container_name -itd -p xxxx:xxxxx image_name**

## Time to test

Okay every service is running as container and is time for testing 

Navigate to http://host_address:4200 and enter the default credentials username: **nithin@fake.com** password: **nithin** and Voila! completely Dockerized working system.


FROM openjdk:8-jdk-alpine
MAINTAINER sarmientojohnkurt@gmail.com
COPY target/kafka-0.0.1-SNAPSHOT.jar logger-ms.jar
ENTRYPOINT ["java","-jar","/logger-ms.jar"]
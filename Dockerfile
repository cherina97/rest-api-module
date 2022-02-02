FROM openjdk:8

COPY event-service-rest/target/app-docker.jar app-docker.jar

ENTRYPOINT ["java","-jar","app-docker.jar"]



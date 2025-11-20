FROM maven:latest
LABEL authors="veikk"

WORKDIR /app
COPY pom.xml /app
COPY . /app

RUN mvn package
CMD ["java", "-jar", "target\myapp.jar"]
FROM maven:3.6.3-jdk-11 as build

LABEL maintainer="github.com/danilotiago"

COPY . .

RUN mvn clean install -DskipTests

FROM openjdk:11-jre-slim-buster

WORKDIR /app

COPY --from=build /target/app.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]
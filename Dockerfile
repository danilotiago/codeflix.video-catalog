FROM maven:3.6.3-jdk-11 as build

LABEL maintainer="github.com/danilotiago"

COPY . .

RUN mvn clean install -DskipTests

FROM openjdk:11-jre-slim-buster

WORKDIR /app

COPY --from=build /target/app.jar /.docker/start.sh ./

EXPOSE 8080

# dockerize listen database up
RUN apt-get update && apt-get install -y wget
ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz
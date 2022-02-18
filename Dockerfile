FROM adoptopenjdk/openjdk14:alpine-jre as builder

COPY . /var/redisDemo/
WORKDIR /var/redisDemo

RUN ./gradlew clean build

ENTRYPOINT java -jar /var/redisDemo/build/libs/*.jar
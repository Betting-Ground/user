FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY /build/libs/user-0.0.1-SNAPSHOT.jar /app/user.jar

ENTRYPOINT ["java", "-jar", "/app/user.jar"]
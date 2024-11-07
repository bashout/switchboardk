# Build
FROM gradle:7.5.1-corretto-21 AS build
WORKDIR /app

COPY build.gradle settings.gradle /app/
COPY src /app/src

RUN gradle build --no-daemon

# Run
FROM amazoncorretto:21-alpine as runtime

WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

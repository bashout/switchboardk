# Build
FROM gradle:jdk21-corretto AS build
WORKDIR /app

COPY build.gradle.kts settings.gradle.kts /app/
COPY src /app/src

RUN gradle build --no-daemon

# Run
FROM amazoncorretto:21-alpine AS runtime

WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

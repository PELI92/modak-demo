FROM gradle:8.3.0-jdk17 AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build --no-daemon


FROM amazoncorretto:17

COPY --from=build /home/gradle/src/build/libs/*.jar /app/app.jar

COPY entrypoint.sh /app/entrypoint.sh

RUN chmod +x /app/entrypoint.sh

ENTRYPOINT ["/app/entrypoint.sh"]
FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 9090
ARG APP_NAME="task"
ARG APP_VERSION="0.0.1"
ARG JAR_FILE="/target/${APP_NAME}-${APP_VERSION}-SNAPSHOT.jar"

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "app.jar"]
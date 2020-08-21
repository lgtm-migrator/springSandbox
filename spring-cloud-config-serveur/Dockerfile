FROM openjdk:8-jre-alpine
ARG JAR_FILE=target/spring-cloud-config-serveur-*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 10800
ENTRYPOINT ["java", "-jar", "/app.jar"]
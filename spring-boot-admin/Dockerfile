FROM openjdk:8-jre-alpine
ARG JAR_FILE=target/spring-boot-admin-*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 10100
ENTRYPOINT ["java", "-jar", "/app.jar"]
FROM openjdk:8-jre-alpine
ARG JAR_FILE=target/spring-cloud-gateway-*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 10200
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "/app.jar"]
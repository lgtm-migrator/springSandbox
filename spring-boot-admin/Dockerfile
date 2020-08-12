FROM openjdk:8u265-jre
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/spring-boot-admin-*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 10100
ENTRYPOINT ["java", "-Dspring.profiles.active=peer1", "-jar", "/app.jar"]
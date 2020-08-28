#!/bin/bash

mvn clean package -DskipTests
java -Xms128m -Xmx192m -jar -Dspring.profiles.active=local ./spring-boot-admin/target/spring-boot-admin-20.08.jar &
sleep 10
java -Xms128m -Xmx192m -jar -Dspring.profiles.active=local,peer1 ./spring-cloud-netflix-eureka/target/spring-cloud-netflix-eureka-20.08.jar &
java -Xms128m -Xmx192m -jar -Dspring.profiles.active=local,peer2 ./spring-cloud-netflix-eureka/target/spring-cloud-netflix-eureka-20.08.jar &
sleep 10
java -Xms128m -Xmx192m -jar -Dspring.profiles.active=local ./spring-cloud-config-serveur/target/spring-cloud-config-serveur-20.08.jar &
sleep 10
java -Xms128m -Xmx192m -jar -Dspring.profiles.active=local ./spring-cloud-gateway/target/spring-cloud-gateway-20.08.jar &
sleep 10
java -Xms128m -Xmx192m -jar -Dspring.profiles.active=local,peer1 ./spring-ms-countries/target/spring-ms-countries-20.08.jar --spring.config.location=classpath:/application-local.yml,classpath:/application-peer1.yml &
sleep 10
java -Xms128m -Xmx192m -jar -Dspring.profiles.active=local,peer2 ./spring-ms-countries/target/spring-ms-countries-20.08.jar --spring.config.location=classpath:/application-local.yml,classpath:/application-peer2.yml &
sleep 10
java -Xms128m -Xmx192m -jar -Dspring.profiles.active=local ./spring-ms-client-backend/target/spring-ms-client-backend-20.08.jar &

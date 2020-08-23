mvn clean package -DskipTests
java -jar ./spring-boot-admin/target/spring-boot-admin-20.08.jar -Dspring.profiles.active=local &
java -jar ./spring-cloud-netflix-eureka/target/spring-cloud-netflix-eureka-20.08.jar -Dspring.profiles.active=local,peer1 &
java -jar ./spring-cloud-netflix-eureka/target/spring-cloud-netflix-eureka-20.08.jar -Dspring.profiles.active=local,peer2 &

FROM openjdk:11
ADD target/appH2-0.0.1-SNAPSHOT.jar docker-casacambio.jar
EXPOSE 8099
ENTRYPOINT ["java", "-jar", "/docker-casacambio.jar"]
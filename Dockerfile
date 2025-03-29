FROM openjdk:25-ea-4-jdk-oraclelinux9

WORKDIR /app

COPY target/ target/
COPY target/*.jar target/app.jar

ENV NAME="Fadlurahman Walid"

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/app.jar"]
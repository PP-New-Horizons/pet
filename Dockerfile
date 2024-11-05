FROM maven:3.9.4-eclipse-temurin-21 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean package -DskipTests

FROM bellsoft/liberica-openjdk-debian:21

RUN adduser --system spring-boot && addgroup --system spring-boot && adduser spring-boot spring-boot
USER spring-boot

WORKDIR /app

COPY --from=build /app/target/*.jar application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]

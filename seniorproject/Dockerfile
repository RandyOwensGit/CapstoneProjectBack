FROM maven:3.8.5-openjdk-17-slim AS build
COPY ./src ./src
COPY pom.xml ./pom.xml
RUN mvn -f ./pom.xml clean package
FROM openjdk:17-jdk-alpine
COPY --from=build /target/seniorproject.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080/tcp
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY ./target/*.jar /app.jar
ENTRYPOINT ["java", "app.jar","-jar"]
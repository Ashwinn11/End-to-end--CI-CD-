FROM openjdk:17-jdk-alphine
WORKDIR /app
COPY ./target/*.jar /app.jar
ENTRYPOINT ["java", "app.jar","-jar"]
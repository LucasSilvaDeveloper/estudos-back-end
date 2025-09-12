FROM eclipse-temurin:17-jdk-alpine
LABEL authors="Felipe"
COPY target/projeto.atualizacao-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
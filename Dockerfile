FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "target/crudbasico-0.0.1-SNAPSHOT.jar"]
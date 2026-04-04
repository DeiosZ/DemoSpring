# ── Etapa 1: compilar ──────────────────────────────────────
FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# ── Etapa 2: imagen final ──────────────────────────────────
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/demo-0.0.1.jar app_demo.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app_demo.jar"]
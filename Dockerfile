FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/demo-0.0.1.jar app_demo.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app_demo.jar"]
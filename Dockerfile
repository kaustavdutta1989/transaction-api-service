FROM openjdk:17
EXPOSE 8705
#WORKDIR /app
COPY . .
ADD target/transaction-api-service.jar  app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
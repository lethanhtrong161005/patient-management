FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk AS runner
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

ENV GRPC_SERVER_PORT=9001
ENV SERVER_PORT=4001

EXPOSE 4001
EXPOSE 9001

ENV GRPC_SERVER_ADDRESS=0.0.0.0

ENTRYPOINT ["java", "-jar", "app.jar"]
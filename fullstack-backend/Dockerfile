# Stage 1: Build the JAR using Maven and JDK 22
FROM maven:3.9.6-eclipse-temurin-22 AS build
WORKDIR /app

# Copy pom and source, then build
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the JAR using JRE 22
FROM eclipse-temurin:22-jre
WORKDIR /app

# Copy the built JAR (assumes one jar in target)
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

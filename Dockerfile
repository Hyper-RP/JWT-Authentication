# Use Java 17
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy jar
COPY target/*.jar app.jar

# Render provides PORT automatically
EXPOSE 8080

# Run app
CMD ["java", "-jar", "app.jar"]

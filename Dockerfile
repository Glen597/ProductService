FROM openjdk:17-jdk-alpine
WORKDIR /app

COPY . .
RUN chmod +x ./gradlew \
 && ./gradlew shadowJar \
 && ls -lh build/libs/

EXPOSE 8080
CMD ["java", "-jar", "build/libs/ProductService-1.0-SNAPSHOT-all.jar"]

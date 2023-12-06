FROM openjdk:17-jdk-slim

WORKDIR /app
COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew build --no-daemon

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "./build/libs/apiUserMonitoring-0.0.1-SNAPSHOT.jar"]
FROM openjdk:17-jdk-slim
WORKDIR /app

COPY . .
COPY env.properties .

RUN chmod +x ./gradlew
RUN ./gradlew build --no-daemon

COPY "./build/libs/apiUserMonitoring-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]
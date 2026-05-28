FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

EXPOSE 8761

CMD ["java", "-jar", "target/discovery-server-0.0.1-SNAPSHOT.jar"]
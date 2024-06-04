FROM amazoncorretto:21
WORKDIR /app
COPY . .
RUN ./mvnw clean install -DskipTests

VOLUME /app/vol

COPY target/*.jar /app/vol/app.jar

EXPOSE 8080


ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://fatatu:fatatu@mongo:27017/diet-generator?authSource=admin", "-jar", "/app/vol/app.jar"]

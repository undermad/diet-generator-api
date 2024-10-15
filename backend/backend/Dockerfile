FROM maven:3.9 as build
WORKDIR /app
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package -DskipTests -X

FROM amazoncorretto:21
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]


#FROM amazoncorretto:21
#WORKDIR /app
#COPY . .
#
#RUN yum install -y dos2unix
#
#RUN dos2unix ./mvnw
#
#RUN chmod +x ./mvnw
#
#RUN ./mvnw clean install -DskipTests
#
#VOLUME /app/vol
#
#COPY target/*.jar /app/vol/app.jar
#
#EXPOSE 8080
#
#
#ENTRYPOINT ["java", "-Dspring.data.mongodb.uri=mongodb://fatatu:fatatu@mongo:27017/diet-generator?authSource=admin", "-jar", "/app/vol/app.jar"]

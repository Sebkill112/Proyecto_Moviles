FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests
RUN mvn clean package 

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Proyecto_Moviles-0.0.1-SNAPSHOT.jar Proyecto_Moviles.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","Proyecto_Movilesr.jar"]
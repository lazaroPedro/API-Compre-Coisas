FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

COPY .mvn/ .mvn/
COPY mvnw .
COPY pom.xml .
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B -DskipTests

COPY src ./src
RUN ./mvnw clean package -B -DskipTests

FROM eclipse-temurin:21-jdk
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

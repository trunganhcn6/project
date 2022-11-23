FROM eclipse-temurin:19-alpine

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
#ADD target/project-0.0.1-SNAPSHOT.jar project-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]

#WORKDIR /app
#
#COPY .mvn/ ./mvn
#COPY mvnw pom.xml ./
#
#RUN ./mvnw dependency:go-offline
#RUN mvn package -Dmaven.test.skip
#
#COPY src ./src
#
#CMD ["./mvnw", "spring-boot:run"]

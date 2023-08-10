FROM maven:3.8.3-openjdk-17 AS build
COPY . /usr/local/SysRes
WORKDIR /usr/local/SysRes/
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17_35-jdk-alpine
ARG JAR_FILE=usr/local/SysRes/target/SysRes-0.0.1-SNAPSHOT.jar
COPY --from=build  ${JAR_FILE}  application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
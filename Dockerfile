FROM maven:3.6.0-jdk-11 as build

COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package -Dmaven.test.skip=true


FROM openjdk:11
WORKDIR /app
COPY --from=build /build/target/bff-tareas-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java","-jar","bff-tareas-0.0.1-SNAPSHOT.jar"]
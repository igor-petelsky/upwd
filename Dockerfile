
FROM maven:3.9-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

CMD ["sh", "-c", "rm -rf allure-results/* && mvn clean test -Dsuite=All -Dremote=true"]

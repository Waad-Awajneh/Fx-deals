FROM adoptopenjdk:11-jdk

WORKDIR /app

COPY target/FXDeals-0.0.1-SNAPSHOT.jar /app/fx.jar

ENTRYPOINT ["java", "-jar", "fx.jar"]


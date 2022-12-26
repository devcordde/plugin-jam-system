FROM docker.io/eclipse-temurin:19-jre

ADD app/build/libs/plugin-jam-system-0.0.1-SNAPSHOT.jar app.jar
ADD application.yaml application.yaml

ENTRYPOINT ["java", "-jar", "app.jar"]

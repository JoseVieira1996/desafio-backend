FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/demo-0.0.1-SNAPSHOT.jar desafio.jar
ENTRYPOINT ["java", "-jar", "/desafio.jar"]
FROM openjdk-11:1.10
MAINTAINER Viktor Kudryavtsev <v.kudryavcev@gmail.com  >
ADD ./target/smlr.jar /app/
CMD ["java", "-jar", "/app/smlr.jar"]
EXPOSE 8080
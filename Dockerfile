FROM java:8-jre
MAINTAINER Viktor Kudryavtsev <v.kudryavcev@gmail.com  >
ADD ./target/smlr.jar /app/
CMD ["java", "-jar", "/app/smlr.jar"]
EXPOSE 8080
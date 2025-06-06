FROM openjdk:8-jdk-alpine
WORKDIR /app
RUN apk update && apk add fontconfig ttf-dejavu
COPY target/ruoyi-admin.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
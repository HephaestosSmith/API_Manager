FROM openjdk:17-jdk-slim
WORKDIR /app
# 如果你需要字型 (例如報表、PDF、圖片)，則保留這行
RUN apt-get update && apt-get install -y fontconfig fonts-dejavu-core
COPY target/ruoyi-admin.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
FROM eclipse-temurin:11-jre-jammy
VOLUME /tmp
ARG SERVER_PORT=9090
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar -Dserver.port=${SERVER_PORT} /app.jar"]
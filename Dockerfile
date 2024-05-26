FROM openjdk:17-alpine
ARG JAR_FILE
ARG JAVA_MEM
COPY ${JAR_FILE} app.jar
ENTRYPOINT java ${JAVA_MEM} -jar /app.jar
#ENTRYPOINT ["java","-Xmx${JAVA_MEM}m" ,"-jar","/app.jar"]
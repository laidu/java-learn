# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="laidu823@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8081

# using beijing timezone
RUN echo "Asia/Shanghai" > /etc/timezone

WORKDIR /data
# The application's jar file
RUN wget https://terwer.oss-cn-qingdao.aliyuncs.com/active/JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT-jar-with-dependencies.jar
ARG JAR_FILE=JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT-jar-with-dependencies.jar

# Add the application's jar to the container
RUN echo ${jar_FILE}
#ADD ${JAR_FILE} JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT-jar-with-dependencies.jar

# Run the jar file
ENTRYPOINT ["java","-jar","JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT-jar-with-dependencies.jar"]
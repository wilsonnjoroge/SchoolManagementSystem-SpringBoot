FROM openjdk:17
VOLUME /tmp
COPY target/schoolmanagementsystem.jar schoolmanagementsystem.jar
ENTRYPOINT ["java","-jar","/schoolmanagementsystem.jar"]


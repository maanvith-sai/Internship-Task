FROM openjdk:17-oracle
VOLUME /tmp
COPY target/*.jar Employee-Management.jar
ENTRYPOINT ["java","-jar","/Employee-Management.jar"]
EXPOSE 8080
#pull jdk image
FROM openjdk:11
#add/copy jar file from target to docker file system
ADD ./target/neo4j-0.0.1-SNAPSHOT.jar /usr/src/neo4j-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
#run the jar file
ENTRYPOINT ["java","-jar","neo4j-0.0.1-SNAPSHOT.jar"]
FROM openjdk:11
EXPOSE 8080
ADD target/community_sever.jar community_sever.jar
ENTRYPOINT ["java","-jar","/community_sever.jar"]
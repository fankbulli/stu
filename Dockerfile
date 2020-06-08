FROM fabric8/java-jboss-openjdk8-jdk

ADD target/*.jar app.jar

VOLUME /tmp

EXPOSE 80

ENTRYPOINT ["java","-jar","app.jar"]
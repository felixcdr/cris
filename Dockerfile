FROM tomcat:9-jdk8-openjdk

ADD target/CRIS-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/CRIS.war

EXPOSE 8080

CMD ["catalina.sh", "run"]

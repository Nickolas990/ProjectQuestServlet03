FROM tomcat:9

EXPOSE 8080

COPY . /opt/yourapplication
WORKDIR /opt/yourapplication
RUN mvn clean install
RUN cp ./target/ProjectServletQuest_03-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
ENTRYPOINT["usr/local/tomcat/bin/catalina.sh", "run"]

COPY ./target/ProjectServletQuest_03-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
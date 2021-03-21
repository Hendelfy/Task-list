#FROM openjdk:11
#VOLUME /tmp
#EXPOSE 8080
#ADD build/libs/demo-0.0.1-SNAPSHOT.jar springbootpostgresqldocker.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springbootpostgresqldocker.jar"]
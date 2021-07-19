FROM openjdk:8
COPY ./target/springboot-crud-practice-1.0.0-SNAPSHOT.jar opt/crudpractice/springboot-crud-practice-1.0.0-SNAPSHOT.jar
EXPOSE 8085
WORKDIR opt/crudpractice
RUN java -jar springboot-crud-practice-1.0.0-SNAPSHOT.jar
#CMD ["java", "-jar", "springboot-crud-practice-1.0.0-SNAPSHOT.jar"]
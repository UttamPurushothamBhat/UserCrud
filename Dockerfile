FROM openjdk:17
EXPOSE 8080
ADD target/usercrud.jar usercrud.jar
ENTRYPOINT [ "java", "-jar", "/usercrud.jar" ]
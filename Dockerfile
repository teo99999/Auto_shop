FROM adoptopenjdk/openjdk11:alpine-jre
COPY build/libs/*.jar cscb869f2020week7.jar
ENTRYPOINT ["java","-jar","/cscb869f2020week7.jar"]

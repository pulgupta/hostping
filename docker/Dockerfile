FROM openjdk:8-jre-alpine
MAINTAINER pulgupta
COPY k8Demo-0.0.1-SNAPSHOT.jar /opt/app/lib/
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/app/lib/k8Demo-0.0.1-SNAPSHOT.jar"]
EXPOSE 8888
FROM openjdk:8u171-alpine3.7
RUN apk --no-cache add curl
COPY target/subs-store-svc*.jar subs-store-svc.jar
CMD java ${JAVA_OPTS} -jar subs-store-svc.jar
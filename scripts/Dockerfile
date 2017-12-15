FROM gradle:4.0.1-alpine as build
MAINTAINER David Chen  <davvvvvvidchen@gmail.com>

ADD ./ /tmp/

RUN cd /tmp && \
    gradle build

FROM java:8-jre-alpine

COPY --from=build /tmp/build/libs/test-spring-cloud-zuul-0.0.1-SNAPSHOT.jar /

ENTRYPOINT ["java", "-server", "-jar", "/test-spring-cloud-zuul-0.0.1-SNAPSHOT.jar"]
FROM quay.io/quarkus/ubi-quarkus-native-image:21.2.0-java11 AS build
WORKDIR /tmp
COPY HelloWorld.java .
RUN javac HelloWorld.java
RUN java -agentlib:native-image-agent=config-output-dir=META-INF/native-image HelloWorld
RUN native-image --no-fallback HelloWorld

FROM quay.io/quarkus/quarkus-distroless-image:1.0
COPY --from=build /tmp/helloworld /helloworld
CMD ["/helloworld"]

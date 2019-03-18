FROM oracle/graalvm-ce:1.0.0-rc13 as graalvm
COPY . /home/app/rabbitmq
WORKDIR /home/app/rabbitmq
RUN native-image --no-server --class-path build/libs/graal-rabbitmq-*.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/rabbitmq .
ENTRYPOINT ["./rabbitmq"]

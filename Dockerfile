FROM oracle/graalvm-ce:1.0.0-rc11 as graalvm
COPY . /home/app/rabbitmq
WORKDIR /home/app/rabbitmq
RUN ./build-native-image.sh

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/rabbitmq .
ENTRYPOINT ["./rabbitmq"]

./gradlew assemble
native-image --no-server --no-fallback --class-path build/libs/graal-rabbitmq-*.jar --initialize-at-build-time=com.rabbitmq.client

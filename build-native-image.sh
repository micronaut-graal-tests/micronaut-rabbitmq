./gradlew assemble
native-image --no-server --no-fallback --class-path build/libs/graal-rabbitmq-*.jar

./gradlew assemble
native-image --no-fallback --class-path build/libs/graal-rabbitmq-*-all.jar

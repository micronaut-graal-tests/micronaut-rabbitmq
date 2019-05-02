# Micronaut RabbitMQ Graal #

Test application for Micronaut and GraalVM that uses:

- RabbitMQ _fire-and-forget_ in package `example.micronaut.rabbitmq.fireandforget`
- RabbitMQ _rpc_ in package `example.micronaut.rabbitmq.rpc`

To test the application:

```
curl localhost:8080/books-fireandforget/1491950358
curl localhost:8080/analytics

curl -s localhost:8080/books-rpc
```

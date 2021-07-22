package example.micronaut.rpc.bookrecommendation;

import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.rabbitmq.annotation.RabbitProperty;
import reactor.core.publisher.Mono;

@RabbitClient("micronaut")
@RabbitProperty(name = "replyTo", value = "amq.rabbitmq.reply-to")
public interface InventoryClient {

    @Binding("books.inventory")
    Mono<Boolean> stock(String isbn);

}

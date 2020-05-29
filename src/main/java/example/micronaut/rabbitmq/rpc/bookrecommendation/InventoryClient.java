package example.micronaut.rabbitmq.rpc.bookrecommendation;

import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.rabbitmq.annotation.RabbitProperty;
import io.reactivex.Maybe;

@RabbitClient("micronaut")
@RabbitProperty(name = "replyTo", value = "amq.rabbitmq.reply-to")
public interface InventoryClient {

    @Binding("books.inventory")
    Maybe<Boolean> stock(String isbn);

}

package example.micronaut.rpc.bookrecommendation;

import example.micronaut.rpc.bookcatalogue.Book;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.rabbitmq.annotation.RabbitProperty;
import reactor.core.publisher.Flux;

import java.util.List;

@RabbitClient("micronaut")
@RabbitProperty(name = "replyTo", value = "amq.rabbitmq.reply-to")
public interface CatalogueClient {

    @Binding("books.catalogue")
    Flux<List<Book>> findAll(byte[] data);

}

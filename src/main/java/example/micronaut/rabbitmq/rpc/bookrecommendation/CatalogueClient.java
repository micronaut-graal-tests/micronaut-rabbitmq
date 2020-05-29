package example.micronaut.rabbitmq.rpc.bookrecommendation;

import example.micronaut.rabbitmq.rpc.bookcatalogue.Book;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.rabbitmq.annotation.RabbitProperty;
import io.reactivex.Flowable;

import java.util.List;

@RabbitClient("micronaut")
@RabbitProperty(name = "replyTo", value = "amq.rabbitmq.reply-to")
public interface CatalogueClient {

    @Binding("books.catalogue")
    Flowable<List<Book>> findAll(byte[] data);

}

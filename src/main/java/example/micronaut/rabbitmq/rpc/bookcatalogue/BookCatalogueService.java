package example.micronaut.rabbitmq.rpc.bookcatalogue;

import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitListener;

import java.util.Arrays;
import java.util.List;

@RabbitListener
public class BookCatalogueService {

    @Queue("catalogue")
    List<Book> listBooks() {
        Book buildingMicroservices = new Book("1491950358", "Building Microservices");
        Book releaseIt = new Book("1680502395", "Release It!");
        Book cidelivery = new Book("0321601912", "Continuous Delivery:");

        return Arrays.asList(buildingMicroservices, releaseIt, cidelivery);
    }
}

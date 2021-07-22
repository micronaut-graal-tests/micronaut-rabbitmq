package example.micronaut.rpc.bookrecommendation;

import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

@Controller("/books-rpc")
public class BookController {

    private final CatalogueClient catalogueClient;
    private final InventoryClient inventoryClient;

    public BookController(CatalogueClient catalogueClient, InventoryClient inventoryClient) {
        this.catalogueClient = catalogueClient;
        this.inventoryClient = inventoryClient;
    }

    @Get("/") // <3>
    @SingleResult
    public Publisher<BookRecommendation> index() {
        return catalogueClient.findAll(null)
                .flatMap(Flux::fromIterable)
                .flatMap(book -> inventoryClient.stock(book.getIsbn())
                        .filter(Boolean::booleanValue)
                        .map(response -> book))
                .map(book -> new BookRecommendation(book.getName()));
    }

}

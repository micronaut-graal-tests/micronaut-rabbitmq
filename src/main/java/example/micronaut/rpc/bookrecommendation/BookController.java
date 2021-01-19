package example.micronaut.rpc.bookrecommendation;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.Flowable;

@Controller("/books-rpc")
public class BookController {

    private final CatalogueClient catalogueClient;
    private final InventoryClient inventoryClient;

    public BookController(CatalogueClient catalogueClient, InventoryClient inventoryClient) {
        this.catalogueClient = catalogueClient;
        this.inventoryClient = inventoryClient;
    }

    @Get("/") // <3>
    public Flowable<BookRecommendation> index() {
        return catalogueClient.findAll(null)
                .flatMap(Flowable::fromIterable)
                .flatMapMaybe(book -> inventoryClient.stock(book.getIsbn())
                        .filter(Boolean::booleanValue)
                        .map(response -> book))
                .map(book -> new BookRecommendation(book.getName()));
    }

}

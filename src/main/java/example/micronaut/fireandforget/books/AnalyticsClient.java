package example.micronaut.fireandforget.books;

import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.rabbitmq.annotation.Binding;

@RabbitClient("micronaut")
public interface AnalyticsClient {

    @Binding("analytics")
    void updateAnalytics(Book book);
}

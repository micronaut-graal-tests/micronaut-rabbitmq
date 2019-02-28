package example.micronaut.rabbitmq.fireandforget.books;

import io.micronaut.configuration.rabbitmq.annotation.Binding;
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient;

@RabbitClient("micronaut")
public interface AnalyticsClient {

    @Binding("analytics")
    void updateAnalytics(Book book);
}

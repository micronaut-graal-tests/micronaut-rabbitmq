package example.micronaut.rabbitmq.fireandforget.analytics;

import example.micronaut.rabbitmq.fireandforget.books.Book;
import io.micronaut.configuration.rabbitmq.annotation.Queue;
import io.micronaut.configuration.rabbitmq.annotation.RabbitListener;

@RabbitListener
public class AnalyticsListener {

    private final AnalyticsService analyticsService;

    public AnalyticsListener(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @Queue("analytics")
    public void updateAnalytics(Book book) {
        analyticsService.updateBookAnalytics(book);
    }
}

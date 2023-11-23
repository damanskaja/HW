package de.telran.g_280323_m_be_shop.schedule;

import de.telran.g_280323_m_be_shop.domain.entity.interfaces.Product;
import de.telran.g_280323_m_be_shop.domain.entity.jpa.Task;
import de.telran.g_280323_m_be_shop.service.interfaces.ProductService;
import de.telran.g_280323_m_be_shop.service.jpa.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class CustomScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomScheduler.class);

    private final TaskService taskService;
    private final ProductService productService;

    public CustomScheduler(TaskService taskService, ProductService productService) {
        this.taskService = taskService;
        this.productService = productService;
    }

    // Регулярное выполнение каждые 30 секунд
    @Scheduled(fixedRate = 30000)
    public void printLastFiveTasks() {
        List<Task> lastFiveTasks = taskService.getLastFiveTasks();
        LOGGER.info("Последние пять выполненных задач: {}", lastFiveTasks);
    }

    // Регулярное выполнение в 15 и 45 секунд каждой минуты
    @Scheduled(cron = "15,45 * * * * *")
    public void logLastAddedProduct() {
        Product lastAddedProduct = productService.getLastAddedProduct();
        LOGGER.info("Последний добавленный в БД продукт - {}", lastAddedProduct);
    }
}

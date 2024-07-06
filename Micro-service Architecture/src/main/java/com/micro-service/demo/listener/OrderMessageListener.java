// OrderMessageListener.java
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageListener {
    @Autowired
    private OrderRepository orderRepository;

    @RabbitListener(queues = "orderQueue")
    public void processOrder(Order order) {
        // Listen back the order msg from queue and insert data into DB.
        orderRepository.save(order);
        System.out.println("Order processed: " + order);
    }
}

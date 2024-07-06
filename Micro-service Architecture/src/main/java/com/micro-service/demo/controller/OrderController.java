// OrderController.java
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setItem(orderDetails.getItem());
                    order.setQuantity(orderDetails.getQuantity());
                    return ResponseEntity.ok(orderRepository.save(order));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Order> partialUpdateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (!optionalOrder.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Order order = optionalOrder.get();

        if (orderDetails.getItem() != null) {
            order.setItem(orderDetails.getItem());
        }
        if (orderDetails.getQuantity() != null) {
            order.setQuantity(orderDetails.getQuantity());
        }

        Order updatedOrder = orderRepository.save(order);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(order -> {
                    // Set order delete msg into queue.
                    rabbitTemplate.convertAndSend("orderQueue", order);
                    orderRepository.delete(order);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

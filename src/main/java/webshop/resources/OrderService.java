package webshop.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    Order create(Order order) {
        return orderRepository.create(order);
    }

    List<Order> getAll() {
        return orderRepository.getAll();
    }

    Order update(Order order) {
        return orderRepository.update(order);
    }

    List<Order> delete(long id) {
       return orderRepository.delete(id);
    }
}

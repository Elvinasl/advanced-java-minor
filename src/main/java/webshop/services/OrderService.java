package webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.data.model.Order;
import webshop.data.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order create(Order order) {
        return orderRepository.create(order);
    }

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Order update(Order order, long id) {
        return orderRepository.update(order, id);
    }

    public List<Order> delete(long id) {
       return orderRepository.delete(id);
    }
}

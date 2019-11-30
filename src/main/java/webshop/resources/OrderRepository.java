package webshop.resources;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private Long id = 1L;
    private List<Order> orders = new ArrayList<>();

    Order create(Order order) {
        order.setId(id++);
        orders.add(order);
        return order;
    }

    List<Order> getAll() {
        return orders;
    }
}

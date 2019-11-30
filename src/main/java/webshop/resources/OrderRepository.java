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

    private Order getById(long id) {
        return orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .get();
    }

    Order update(Order order) {
        Order oldOrder = this.getById(order.getId());
        oldOrder.setAmount(order.getAmount());
        oldOrder.setName(order.getName());
        return oldOrder;
    }

    List<Order> delete(long id) {
        orders.removeIf(o -> o.getId().equals(id));
        return getAll();
    }
}

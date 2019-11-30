package webshop.resources;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WebShopRepository {

    private List<Order> orders = new ArrayList<>();

    Order create(Order order) {
        orders.add(order);
        return order;
    }
}

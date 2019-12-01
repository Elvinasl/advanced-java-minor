import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import resources.TestApplicationContext;
import webshop.data.OrderRepository;
import webshop.data.model.Order;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestApplicationContext.class)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testAdd() {
        Order createdOrder = orderRepository.create(this.mockOrder());

        Assertions.assertTrue(createdOrder.getId() > 0);
        Assertions.assertEquals(BigDecimal.TEN, createdOrder.getAmount());
        Assertions.assertEquals("Test 1", createdOrder.getName());
    }

    @Test
    public void testGetAll() {
        orderRepository.create(this.mockOrder());
        List<Order> orders = orderRepository.getAll();

        Assertions.assertTrue(orders.size() >= 1); // not depending on tests order
        Assertions.assertNotNull(orders.get(0));
    }

    @Test
    public void deleteOrder() {
        Order order = orderRepository.create(this.mockOrder());
        orderRepository.delete(order.getId());
        orderRepository.getAll().forEach(o -> Assertions.assertNotEquals(o.getId(), order.getId()));
    }

    @Test
    public void updateOrder() {
        Order order = orderRepository.create(this.mockOrder());
        order.setName("Updated");
        order.setAmount(BigDecimal.ONE);
        Order updatedOrder = orderRepository.update(order);

        Assertions.assertEquals(updatedOrder.getId(), order.getId());
        Assertions.assertEquals(updatedOrder.getAmount(), BigDecimal.ONE);
        Assertions.assertEquals("Updated", updatedOrder.getName());
    }

    private Order mockOrder() {
        Order order = new Order();
        order.setAmount(BigDecimal.TEN);
        order.setName("Test 1");
        return order;
    }
}

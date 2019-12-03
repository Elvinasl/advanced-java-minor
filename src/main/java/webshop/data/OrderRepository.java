package webshop.data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import webshop.data.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class OrderRepository {

    /**
     * This gives us an EntityManager.
     * Or, well, a proxy to one. Which gives or creates a thread-safe EntityManager for us
     * every time we use it.
     */
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    public Order getById(Long id) {
        return em.find(Order.class, id);
    }

    public Order create(Order order) {
        em.persist(order);
        return order;
    }

    public List<Order> getAll() {
        return em.createQuery("SELECT o FROM Order o ", Order.class).getResultList();
    }

    public Order update(Order order, long id) {
        order.setId(id);
        em.merge(order);
        return order;
    }

    public List<Order> delete(long id) {
        em.remove(this.getById(id));
        return getAll();
    }
}

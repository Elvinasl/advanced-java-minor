package webshop.data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import webshop.data.model.Order;
import webshop.exceptions.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class OrderRepository {

    /**
     * This gives us an EntityManager.
     * Or, well, a proxy to one. Which gives or creates a thread-safe EntityManager for us
     * every time we use it.
     */
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Transactional
    public Order getById(Long id) {
        return em.find(Order.class, id);
    }

    @Transactional
    public Order create(Order order) {
        em.persist(order);
        return order;
    }

    @Transactional
    public List<Order> getAll() {
        return em.createQuery("SELECT o FROM Order o ", Order.class).getResultList();
    }

    @Transactional
    public Order update(Order order, long id) {
        checkIfExists(id);
        order.setId(id);
        em.merge(order);
        return order;
    }

    @Transactional
    public List<Order> delete(long id) {
        checkIfExists(id);
        em.remove(this.getById(id));
        return getAll();
    }

    private void checkIfExists(long id) {
        if (getById(id) == null) {
            throw new NotFoundException("Order with this id was not found!");
        }
    }
}

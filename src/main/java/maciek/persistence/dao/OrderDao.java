package maciek.persistence.dao;

import maciek.persistence.dto.OrderDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class OrderDao {

    @PersistenceContext(unitName = "mnshopdbPU")
    private EntityManager entityManager;

    public OrderDto findById(int id) {
        return entityManager.find(OrderDto.class, id);
    }

    public List<OrderDto> findByCustomer(int customerId) {
        List<OrderDto> orderDtos = entityManager
                .createQuery("from OrderDto o where o.customer.id = :customerId", OrderDto.class)
                .setParameter("customerId", customerId)
                .getResultList();
        return orderDtos;
    }

    public List<OrderDto> list() {
        return entityManager.createQuery("from OrderDto", OrderDto.class).getResultList();
    }

    public void save(OrderDto orderDto) {
        entityManager.persist(orderDto);
    }
}

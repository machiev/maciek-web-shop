package maciek.persistence.dao;

import maciek.persistence.dto.Customer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CustomerDao {

    @PersistenceContext(unitName = "mnshopdbPU")
    private EntityManager entityManager;

    public Customer findById(int id) {
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    public List<Customer> findByName(String name) {
        return entityManager.createQuery("from Customer c where c.name = :name", Customer.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Customer> list() {
        List<Customer> customers = entityManager.createQuery("from Customer", Customer.class).getResultList();
        return customers;
    }

    public void save(Customer customer) {
        entityManager.persist(customer);
    }
}

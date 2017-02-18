package maciek.service;

import maciek.domain.Person;
import maciek.persistence.dao.CustomerDao;
import maciek.persistence.dto.Customer;
import maciek.service.converter.CustomerConverter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class LoginService {

    private CustomerDao customerDao;

    @Inject
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Person verifyCredentials(String name, String password) {
        List<Customer> customers = customerDao.findByName(name);
        if (customers == null || customers.size() != 1) {
            return null;
        }
        Customer customer = customers.get(0);
        return CustomerConverter.fromDto(customer);
    }
}

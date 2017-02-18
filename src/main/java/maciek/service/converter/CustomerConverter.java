package maciek.service.converter;

import maciek.domain.Person;
import maciek.persistence.dto.Customer;

public class CustomerConverter {

    public static Person fromDto(Customer customer) {
        return new Person(customer.getId(), customer.getName(), customer.getSurname());
    }

    public static Customer toDto(Person person) {
        return new Customer(person.getId(), person.getName(), person.getSurname());
    }
}

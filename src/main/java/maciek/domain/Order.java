package maciek.domain;

import java.util.List;

public class Order {

    private Integer id;
    private Person person;
    private List<OrderItem> items;

    public Order(Person person, List<OrderItem> items) {
        this(null, person, items);
    }

    public Order(Integer id, Person person, List<OrderItem> items) {
        this.id = id;
        this.person = person;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public int getCustomerId() {
        return person.getId();
    }
}

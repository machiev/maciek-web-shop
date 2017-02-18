package maciek.persistence.dto;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "cust_order")
public class OrderDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="cust_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name="ord_id", referencedColumnName="id", nullable = false)
    private List<OrderItemDto> items;

    public OrderDto() {
        //default constructor for Hibernate
    }

    public OrderDto(Customer customer, List<OrderItemDto> items) {
        this(null, customer, items);
    }

    public OrderDto(Integer id, Customer customer, List<OrderItemDto> items) {
        this.id = id;
        this.customer = customer;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

}

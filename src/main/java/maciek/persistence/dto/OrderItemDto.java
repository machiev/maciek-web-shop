package maciek.persistence.dto;

import javax.persistence.*;

/**
 * Created by Maciek on 2016-12-18.
 */
@Entity
@Table(name = "order_item")
public class OrderItemDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "description", length = 64)
    private String description;

    @Column(name = "count")
    private int count;

    public OrderItemDto() {
        //default constructor for Hibernate
    }

    public OrderItemDto(String name, String description, int count) {
        this(null, name, description, count);
    }

    public OrderItemDto(Integer id, String name, String description, int count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}

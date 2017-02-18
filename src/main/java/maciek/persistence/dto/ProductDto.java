package maciek.persistence.dto;

import javax.persistence.*;

/**
 * Created by Maciek on 2016-12-18.
 */
@Entity
@Table(name = "product")
public class ProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "description", length = 64)
    private String description;

    public ProductDto() {
        //default constructor for Hibernate
    }

    public ProductDto(String name, String description) {
        this(null, name, description);
    }

    public ProductDto(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", description=" + description;
    }
}

package maciek.domain;

import java.util.concurrent.atomic.AtomicInteger;

public class OrderItem {
    private Integer id;
    private String name;
    private String description;
    private int count;
//    private static AtomicInteger idGen = new AtomicInteger(1);

    public OrderItem(String name, String description, int count) {
        this(null, name, description, count);
    }

    public OrderItem(Integer id, String name, String description, int count) {
        this.id = id;
//        this.id = idGen.getAndIncrement();
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

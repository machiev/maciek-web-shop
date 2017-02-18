package maciek.service;

import maciek.domain.Order;
import maciek.domain.OrderItem;
import maciek.domain.Person;
import maciek.domain.Product;
import maciek.persistence.dao.OrderDao;
import maciek.persistence.dto.OrderDto;
import maciek.service.converter.OrderConverter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OrderService {

    private OrderDao orderDao;

    @Inject
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Order createOrder(@NotNull Person user, @NotNull List<Product> products) {
        List<OrderItem> items = new ArrayList<>(products.size());
        for (Product product : products) {
            items.add(new OrderItem(product.getId(), product.getName(), product.getDescription(), 1));
        }
        return new Order(user, items);
    }

    public void save(@NotNull Order newOrder) {
        OrderDto orderDto = OrderConverter.toDto(newOrder);
        orderDao.save(orderDto);
    }

    public List<Order> findByCustomer(int customerId) {
        List<OrderDto> orderDtos = orderDao.findByCustomer(customerId);
        return OrderConverter.fromDtos(orderDtos);
    }

}

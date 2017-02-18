package maciek.service.converter;

import maciek.domain.Order;
import maciek.domain.OrderItem;
import maciek.persistence.dto.OrderDto;
import maciek.persistence.dto.OrderItemDto;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {

    public static OrderDto toDto(Order newOrder) {
        List<OrderItem> newOrderItems = newOrder.getItems();
        List<OrderItemDto> items = new ArrayList<>(newOrderItems.size());
        for (maciek.domain.OrderItem newOrderItem : newOrderItems) {
            items.add(new OrderItemDto(newOrderItem.getName(), newOrderItem.getDescription(), newOrderItem.getCount()));
        }
        return new OrderDto(CustomerConverter.toDto(newOrder.getPerson()), items);
    }

    public static List<OrderDto> toDtos(List<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>(orders.size());
        for (Order order : orders) {
            orderDtos.add(toDto(order));
        }
        return orderDtos;
    }

    public static Order fromDto(OrderDto orderDto) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemDto orderItemDto : orderDto.getItems()) {
            orderItems.add(new OrderItem(orderItemDto.getId(), orderItemDto.getName(), orderItemDto.getDescription(), orderItemDto.getCount()));
        }
        return new Order(orderDto.getId(), CustomerConverter.fromDto(orderDto.getCustomer()), orderItems);
    }

    public static List<Order> fromDtos(List<OrderDto> orderDtos) {
        List<Order> orders = new ArrayList<>();
        for (OrderDto orderDto : orderDtos) {
            orders.add(OrderConverter.fromDto(orderDto));
        }
        return orders;
    }
}

package br.com.erpsystem.order.api.mapper;

import java.util.List;

import br.com.erpsystem.order.api.dtos.OrderRequest;
import br.com.erpsystem.order.api.dtos.OrderResponse;
import br.com.erpsystem.order.models.Order;

public class OrderMapper {

    
    public static Order toDomain(OrderRequest request) {
        Order order = new Order();
        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());
        return order;
    }


    public static OrderResponse toResponse(Order request) {
        OrderResponse order = new OrderResponse();
        order.setId(order.getId());
        order.setCreatedAt(order.getCreatedAt());
        order.setSkuCode(order.getSkuCode());
        order.setPrice(order.getPrice());
        order.setQuantity(order.getQuantity());
        return order;
    }

    public static List<OrderResponse> toResponseList(List<Order> orders) {
        return orders.stream().map(OrderMapper::toResponse).toList();
    }


}

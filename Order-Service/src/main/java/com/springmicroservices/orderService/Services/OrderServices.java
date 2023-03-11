package com.springmicroservices.orderService.Services;

import com.springmicroservices.orderService.DTO.OrderLineItemsDto;
import com.springmicroservices.orderService.DTO.OrderRequest;
import com.springmicroservices.orderService.Models.Order;
import com.springmicroservices.orderService.Models.OrderLineItems;
import com.springmicroservices.orderService.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServices {

    private final OrderRepository orderRepository;

    public void PlaceOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

  order.setOrderLineItemsList(orderLineItems);
  orderRepository.save(order);
    }


    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItems.getPrice());
        orderLineItems.setQuantity(orderLineItems.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return orderLineItems;

    }
}

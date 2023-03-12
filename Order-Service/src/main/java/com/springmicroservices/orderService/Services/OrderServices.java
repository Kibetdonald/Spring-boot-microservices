package com.springmicroservices.orderService.Services;

import com.springmicroservices.orderService.DTO.InventoryResponse;
import com.springmicroservices.orderService.DTO.OrderLineItemsDto;
import com.springmicroservices.orderService.DTO.OrderRequest;
import com.springmicroservices.orderService.Models.Order;
import com.springmicroservices.orderService.Models.OrderLineItems;
import com.springmicroservices.orderService.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServices {

    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public void PlaceOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

  order.setOrderLineItemsList(orderLineItems);
        List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();
//  We need to check if the product is in stock before placing the order
    InventoryResponse[] inventoryResponses = webClient.get()
            .uri("http://localhost:5002/api/inventory",
                    uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build()  )
            .retrieve()
                    .bodyToMono(InventoryResponse[].class)
                            .block();
       boolean allProductsInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
    if(allProductsInStock){
        orderRepository.save(order);
    }else {
        throw new IllegalArgumentException("Product is out of stock");
    }

    }


    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItems.getPrice());
        orderLineItems.setQuantity(orderLineItems.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return orderLineItems;

    }
}

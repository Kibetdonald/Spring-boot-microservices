package com.springmicroservices.orderService.Controller;


import com.springmicroservices.orderService.DTO.OrderRequest;
import com.springmicroservices.orderService.Services.OrderServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServices orderServices;
    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderServices.PlaceOrder(orderRequest);
        return "Order placed";
    }
}

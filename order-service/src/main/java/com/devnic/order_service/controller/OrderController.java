package com.devnic.order_service.controller;


import com.devnic.order_service.dto.OrderRequest;
import com.devnic.order_service.services.PlaceOrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nicholas Nzovia
 * @On 25/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final PlaceOrderService placeOrderService;
    public OrderController(PlaceOrderService placeOrderService) {
        this.placeOrderService = placeOrderService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory-s", fallbackMethod = "inventoryCallFallBack") //monitoring any method calls done here
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        placeOrderService.makeAnOrder(orderRequest);
        return "We have Received Your Order";
    }

    //method called the times we are unable to call PlaceOrderMethod, or when PlaceOrder Method returns a fail
    public String inventoryCallFallBack(OrderRequest orderRequest, RuntimeException exception){
        return "Unable to place your Order, please retry after 5 minutes";
    }
}

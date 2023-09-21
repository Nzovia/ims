package com.devnic.order_service.controller;


import com.devnic.order_service.dto.OrderRequest;
import com.devnic.order_service.services.PlaceOrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

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
    @TimeLimiter(name="inventory-s")
    @Retry(name="inventory-s")
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest){
        return CompletableFuture.supplyAsync(()->placeOrderService.makeAnOrder(orderRequest));
    }

    //method called the times we are unable to call PlaceOrderMethod, or when PlaceOrder Method returns a fail
    public CompletableFuture<String> inventoryCallFallBack(OrderRequest orderRequest, RuntimeException exception){
        return CompletableFuture.supplyAsync(()-> "Unable to place your Order, please retry after 5 minutes");
    }
}

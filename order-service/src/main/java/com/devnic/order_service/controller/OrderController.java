package com.devnic.order_service.controller;


import com.devnic.order_service.dto.OrderRequest;
import com.devnic.order_service.services.PlaceOrderService;
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
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        placeOrderService.makeAnOrder(orderRequest);
        return "Order Placed Successfully";
    }
}

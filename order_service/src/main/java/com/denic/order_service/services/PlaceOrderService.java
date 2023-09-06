package com.denic.order_service.services;

import com.denic.order_service.dto.OrderLineItemsDto;
import com.denic.order_service.dto.OrderRequest;
import com.denic.order_service.models.Order;
import com.denic.order_service.models.OrderLineItems;
import com.denic.order_service.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 26/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
@Slf4j
public class PlaceOrderService {
    private final OrderRepository orderRepository;
    public PlaceOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void makeAnOrder(OrderRequest orderRequest){
        GenerateOrderNumberService orderNumberService = new GenerateOrderNumberService();
        var  orderNumber = orderNumberService.generateRandomNumber();

        Order order = new Order();
        order.setOrderNumber(orderNumber);

        //mapping orderLineItems to orderRequest
       List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

       //setOrderLineItems into the order request
        order.setOrderLineItems(orderLineItems);

        //save to the dataBase
        orderRepository.save(order);
        log.info("order with number {} created successfully", orderNumber);

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();

        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        return orderLineItems;
    }
}

package com.devnic.order_service.services;

import com.devnic.order_service.dto.InventoryResponse;
import com.devnic.order_service.dto.OrderLineItemsDto;
import com.devnic.order_service.dto.OrderRequest;
import com.devnic.order_service.models.Order;
import com.devnic.order_service.models.OrderLineItems;
import com.devnic.order_service.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 26/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
@Slf4j
@Transactional
public class PlaceOrderService {
    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public PlaceOrderService(OrderRepository orderRepository, WebClient webClient) {
        this.orderRepository = orderRepository;
        this.webClient = webClient;
    }

    public void makeAnOrder(OrderRequest orderRequest) {
        GenerateOrderNumberService orderNumberService = new GenerateOrderNumberService();
        var orderNumber = orderNumberService.generateRandomNumber();

        Order order = new Order();
        order.setOrderNumber(orderNumber);

        //mapping orderLineItems to orderRequest
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        //setOrderLineItems into the order request
        order.setOrderLineItems(orderLineItems);

        //collecting all skuCode codes from different order-items in the same order
        List<String> skuCodes = order.getOrderLineItems().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        /*
         * Call the inventory service to check whether the item ordered is still in stock*/
        InventoryResponse[] inventoryResponses = webClient.get()
                .uri("http://localhost:8079/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block(); //making web client return a synchronous request


        //stream through to check whether all the products are in stock
        boolean allMatchToProductsInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);

        //when the result is true then we can make an order  else return a exception
        if (allMatchToProductsInStock) {
            //save to the dataBase
            orderRepository.save(order);
            log.info("order with number {} created successfully", orderNumber);
        } else {
            throw new IllegalArgumentException("One of the ordered items might be out stock." +
                    " please retry after 30min");
        }

    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();

        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setItemName(orderLineItems.getItemName());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        return orderLineItems;
    }
}

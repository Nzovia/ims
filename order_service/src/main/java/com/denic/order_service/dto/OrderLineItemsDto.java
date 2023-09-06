package com.denic.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Nicholas Nzovia
 * @On 25/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsDto {
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}

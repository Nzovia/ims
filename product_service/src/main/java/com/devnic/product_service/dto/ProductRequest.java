package com.devnic.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Nicholas Nzovia
 * @On 18/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;

}

package com.devnic.inventory_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nicholas Nzovia
 * @On 12/09/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;
}

package com.devnic.inventory_service.controllers;

import com.devnic.inventory_service.dtos.InventoryResponse;
import com.devnic.inventory_service.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 08/09/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    // Get Request to get the inventory Status
    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isItemOrderedInStock(@RequestParam(name = "sku-code") List<String> skuCode){
        return  inventoryService.itemsAreStillInStock(skuCode);
    }
}

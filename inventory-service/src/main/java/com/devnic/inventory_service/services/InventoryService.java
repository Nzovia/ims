package com.devnic.inventory_service.services;

import com.devnic.inventory_service.dtos.InventoryResponse;
import com.devnic.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 08/09/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    // Service method to check whether items being requested in the order stocked
    @Transactional(readOnly = true)
    public List<InventoryResponse> itemsAreStillInStock(List<String> skuCode) {
        log.info("Wait has Started");
        log.info("Wait has ended");
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity() > 0)
                            .build()
                ).toList();
    }
}

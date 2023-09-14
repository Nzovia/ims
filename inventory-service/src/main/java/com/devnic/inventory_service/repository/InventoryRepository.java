package com.devnic.inventory_service.repository;

import com.devnic.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author Nicholas Nzovia
 * @On 08/09/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
//    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}

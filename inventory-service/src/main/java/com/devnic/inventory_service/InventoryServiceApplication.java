package com.devnic.inventory_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

 //    @Bean
//    public CommandLineRunner loadData(InventoryRepository inventoryRepository){
//        return args -> {
//            Inventory inventory = new Inventory();
//            inventory.setSkuCode("RC12");
//            inventory.setProductName("Rice");
//            inventory.setUnitOfMeasure("KG");
//            inventory.setQuantity(4);
//
//            Inventory inventory1 = new Inventory();
//            inventory1.setSkuCode("UG12");
//            inventory1.setProductName("unga");
//            inventory1.setUnitOfMeasure("KG");
//            inventory1.setQuantity(4);
//
//            Inventory inventory2 = new Inventory();
//            inventory2.setSkuCode("CF12");
//            inventory2.setProductName("Coffee");
//            inventory2.setUnitOfMeasure("Pieces");
//            inventory2.setQuantity(40);
//
//            Inventory inventory3 = new Inventory();
//            inventory3.setSkuCode("OL14");
//            inventory3.setProductName("Cooking Oil");
//            inventory3.setUnitOfMeasure("Ltr");
//            inventory3.setQuantity(45);
//
//            inventoryRepository.save(inventory);
//            inventoryRepository.save(inventory1);
//            inventoryRepository.save(inventory2);
//            inventoryRepository.save(inventory3);
//
//        };
//    }


}

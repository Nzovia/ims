package com.devnic.product_service.repositories;

import com.devnic.product_service.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Nicholas Nzovia
 * @On 19/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
public interface ProductsRepository extends MongoRepository<Product, String> {
}

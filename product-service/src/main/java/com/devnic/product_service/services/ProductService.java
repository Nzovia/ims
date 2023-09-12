package com.devnic.product_service.services;


import com.devnic.product_service.dto.ProductRequest;
import com.devnic.product_service.dto.ProductResponse;
import com.devnic.product_service.models.Product;
import com.devnic.product_service.repositories.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nicholas Nzovia
 * @On 18/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */

@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductsRepository productRepository;
    public  void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .productName(productRequest.getProductName())
                .productDescription(productRequest.getProductDescription())
                .productPrice(productRequest.getProductPrice())
                .build();

        productRepository.save(product);
        log.info("product saved {}", product.getProductName());

    }

    public List<ProductResponse> getAllProducts() {
       List<Product> products = productRepository.findAll();
      return products.stream().map(this::mapToProductResponse).toList();

    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productPrice(product.getProductPrice())
                .build();
    }
}

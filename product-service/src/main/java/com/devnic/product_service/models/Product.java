package com.devnic.product_service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

/**
 * @author Nicholas Nzovia
 * @On 03/03/2023
 * @Contact: itsdevelopernic22@gmail.com
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "product")
public class Product {
    @Id
    private String id;
    private String productName;
    private String productDescription;
    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal productPrice;
    //private String productQuantity;
}

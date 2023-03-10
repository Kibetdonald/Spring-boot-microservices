package com.buildingmicroservices.Product.Service.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Products")
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id

    private String id;
    private String name;
    private String description;
    private String price;

}

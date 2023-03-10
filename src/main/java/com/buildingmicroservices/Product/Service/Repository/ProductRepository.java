package com.buildingmicroservices.Product.Service.Repository;

import com.buildingmicroservices.Product.Service.Models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}

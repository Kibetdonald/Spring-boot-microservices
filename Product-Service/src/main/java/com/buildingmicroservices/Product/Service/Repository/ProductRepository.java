package com.buildingmicroservices.Product.Service.Repository;

import com.buildingmicroservices.Product.Service.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}

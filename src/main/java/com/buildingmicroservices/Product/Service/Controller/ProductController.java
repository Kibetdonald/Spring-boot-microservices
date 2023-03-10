package com.buildingmicroservices.Product.Service.Controller;

import com.buildingmicroservices.Product.Service.DTO.ProductRequest;
import com.buildingmicroservices.Product.Service.DTO.ProductResponse;
import com.buildingmicroservices.Product.Service.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping("/products")
    public List<ProductResponse> getAllProducts(){
  return productService.getAllProducts();
    }



}

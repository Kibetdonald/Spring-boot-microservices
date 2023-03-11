package com.example.InventoryService.Controller;

import com.example.InventoryService.Services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/inventory")
    @ResponseStatus(HttpStatus.OK)
    public boolean IsInStock(@PathVariable("sku-code")String skuCode){
        return inventoryService.IsInStock(skuCode);

    }
}

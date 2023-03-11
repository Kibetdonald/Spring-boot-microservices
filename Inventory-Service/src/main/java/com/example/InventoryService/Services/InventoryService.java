package com.example.InventoryService.Services;

import com.example.InventoryService.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    public boolean IsInStock(String skuCode){
       return inventoryRepository.findBySkuCode().isPresent();

    }

}

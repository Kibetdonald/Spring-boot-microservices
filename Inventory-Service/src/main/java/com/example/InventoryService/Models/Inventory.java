package com.example.InventoryService.Models;


import jakarta.persistence.*;
import lombok.*;

@Table(name="InventoryTable")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;

}

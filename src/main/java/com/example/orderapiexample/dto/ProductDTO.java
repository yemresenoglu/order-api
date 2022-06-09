package com.example.orderapiexample.dto;


import java.math.BigDecimal;
import java.util.UUID;

public record ProductDTO(String name,
                         BigDecimal price,
                         UUID barcode,
                         String image,
                         Long brandID,
                         Long categoryID) {
}

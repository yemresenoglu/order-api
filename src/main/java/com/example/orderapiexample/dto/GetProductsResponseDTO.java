package com.example.orderapiexample.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record GetProductsResponseDTO(Long id, String name,
                                     BigDecimal price,
                                     UUID barcode,
                                     String image,
                                     BrandDTO brand,
                                     CategoryDTO category) {
}

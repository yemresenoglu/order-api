package com.example.orderapiexample.dto;

import java.math.BigDecimal;

public record GetBasketItemsResponseDTO(Long basketId,
                                        Long productId,
                                        BigDecimal quantity,
                                        BigDecimal price,
                                        BigDecimal discountPrice,
                                        BigDecimal taxPrice) {
}

package com.example.orderapiexample.dto;

import java.math.BigDecimal;

public record BasketItemDTO(Long basketId,
                            Long productId,
                            BigDecimal quantity,
                            BigDecimal price,
                            BigDecimal discountPrice,
                            BigDecimal taxPrice) {
}

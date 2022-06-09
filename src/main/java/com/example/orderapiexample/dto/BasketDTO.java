package com.example.orderapiexample.dto;

import java.math.BigDecimal;

public record BasketDTO(Long customerID,
                        BigDecimal price,
                        BigDecimal discountPrice,
                        BigDecimal taxPrice,
                        BigDecimal shippingPrice,
                        BigDecimal totalPrice) {
}

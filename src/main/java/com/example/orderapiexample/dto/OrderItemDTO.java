package com.example.orderapiexample.dto;

import java.math.BigDecimal;

public record OrderItemDTO(Long orderID,
                           BigDecimal price,
                           BigDecimal discountPrice,
                           BigDecimal taxPrice,
                           BigDecimal shippingPrice,
                           BigDecimal totalPrice,
                           BigDecimal quantity,
                           Long productID) {
}

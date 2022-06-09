package com.example.orderapiexample.dto;

import java.math.BigDecimal;
import java.util.Date;

public record CouponDTO(String title,
                        String description,
                        Date startDate,
                        Date endDate,
                        String code,
                        Integer quantity,
                        BigDecimal discountAmount) {
}

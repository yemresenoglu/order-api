package com.example.orderapiexample.dto;


import java.math.BigDecimal;
import java.util.Date;

public record OrderDTO(Date shippingDate,
                       String shippingMethod,
                       String orderStatus,
                       BigDecimal orderPrice,
                       BigDecimal orderDiscountPrice,
                       BigDecimal orderTaxPrice,
                       BigDecimal orderShippingPrice,
                       BigDecimal orderTotalPrice,
                       Long orderItemID,
                       Long shippingAddressID,
                       Long paymentID
                      ) {
}

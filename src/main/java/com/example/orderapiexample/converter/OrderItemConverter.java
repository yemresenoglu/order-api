package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.OrderItemDTO;
import com.example.orderapiexample.model.OrderItem;

public interface OrderItemConverter {

    OrderItem addToOrderItem(OrderItemDTO orderItemDTO);
}

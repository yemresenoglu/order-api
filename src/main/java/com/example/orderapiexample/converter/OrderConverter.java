package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.OrderDTO;
import com.example.orderapiexample.model.Order;

public interface OrderConverter {

    Order toCreateOrder(OrderDTO orderDTO);
}

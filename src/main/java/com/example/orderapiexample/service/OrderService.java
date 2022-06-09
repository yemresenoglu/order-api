package com.example.orderapiexample.service;

import com.example.orderapiexample.dto.OrderDTO;
import com.example.orderapiexample.model.Order;

public interface OrderService {

    void createOrder(OrderDTO orderDTO);

    Order getOneOrder(Long orderID);
}

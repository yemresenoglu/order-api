package com.example.orderapiexample.service;

import com.example.orderapiexample.converter.OrderConverter;
import com.example.orderapiexample.dto.OrderDTO;
import com.example.orderapiexample.exception.OrderServiceException;
import com.example.orderapiexample.model.Order;
import com.example.orderapiexample.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    @Override
    public void createOrder(OrderDTO orderDTO) {
        Order order = orderConverter.toCreateOrder(orderDTO);
        orderRepository.save(order);
    }

    @Override
    public Order getOneOrder(Long orderID) {

        Order order = orderRepository
                .findById(orderID)
                .orElseThrow(()-> new OrderServiceException.OrderNotFoundException("Order not found!"));
        return order;
    }
}

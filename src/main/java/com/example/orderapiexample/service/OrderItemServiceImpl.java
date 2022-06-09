package com.example.orderapiexample.service;

import com.example.orderapiexample.converter.OrderItemConverter;
import com.example.orderapiexample.dto.OrderItemDTO;
import com.example.orderapiexample.model.OrderItem;
import com.example.orderapiexample.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService{

    private final OrderItemRepository orderItemRepository;
    private final OrderItemConverter orderItemConverter;

    @Override
    public void addOrderItem(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = orderItemConverter.addToOrderItem(orderItemDTO);
        orderItemRepository.save(orderItem);
    }
}

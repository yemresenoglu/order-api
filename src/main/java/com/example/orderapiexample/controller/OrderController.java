package com.example.orderapiexample.controller;

import com.example.orderapiexample.dto.OrderDTO;
import com.example.orderapiexample.dto.OrderItemDTO;
import com.example.orderapiexample.service.OrderItemService;
import com.example.orderapiexample.service.OrderService;
import com.example.orderapiexample.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final Validator<OrderDTO> orderDTOValidator;
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final Validator<OrderItemDTO> orderItemDTOValidator;


    @PostMapping
    private ResponseEntity<?> createOrder(OrderDTO orderDTO)
    {
        orderDTOValidator.validate(orderDTO);
        orderService.createOrder(orderDTO);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/orderItem")
    private ResponseEntity<?> addOrderItem(OrderItemDTO orderItemDTO)
    {
        orderItemDTOValidator.validate(orderItemDTO);
        orderItemService.addOrderItem(orderItemDTO);

        return ResponseEntity.ok().build();
    }

}

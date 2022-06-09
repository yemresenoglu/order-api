package com.example.orderapiexample.validator;

import com.example.orderapiexample.dto.OrderItemDTO;
import com.example.orderapiexample.exception.BaseException;
import org.springframework.stereotype.Component;

@Component
public class OrderItemDTOValidator implements Validator<OrderItemDTO>{

    @Override
    public void validate(OrderItemDTO orderItemDTO) throws BaseException {

    }
}

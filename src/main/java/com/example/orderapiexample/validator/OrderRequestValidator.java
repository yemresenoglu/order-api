package com.example.orderapiexample.validator;

import com.example.orderapiexample.dto.OrderDTO;
import com.example.orderapiexample.exception.BaseException;
import com.example.orderapiexample.exception.OrderServiceException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class OrderRequestValidator implements Validator<OrderDTO>{

    @Override
    public void validate(OrderDTO orderDTO) throws BaseException {
        if(Objects.isNull(orderDTO.shippingDate()))
        {
            throw new OrderServiceException.OrderNotValidException("Order shipping date can not be null or empty!");
        }

        //other value will be complete.

    }
}

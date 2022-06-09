package com.example.orderapiexample.validator;


import com.example.orderapiexample.exception.BaseException;
import com.example.orderapiexample.exception.CustomerServiceOperationException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CustomerIDValidator implements Validator<Long>{
    @Override
    public void validate(Long id) throws BaseException {
        if (id < 0) {
            throw new CustomerServiceOperationException.CustomerIDNotValidException("Customer ID should be greater than zero.");
        }
    }
}

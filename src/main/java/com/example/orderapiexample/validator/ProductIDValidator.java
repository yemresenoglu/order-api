package com.example.orderapiexample.validator;

import com.example.orderapiexample.exception.BaseException;
import com.example.orderapiexample.exception.ProductServiceOperationException;
import org.springframework.stereotype.Component;

@Component
public class ProductIDValidator implements Validator<Long> {

    @Override
    public void validate(Long id) throws BaseException {

        if(id<=0)
        {
            throw new ProductServiceOperationException.ProductIDNotValidException("Product ID can not be equal or less than zero.");
        }
    }
}

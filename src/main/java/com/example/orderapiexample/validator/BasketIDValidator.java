package com.example.orderapiexample.validator;

import com.example.orderapiexample.exception.BaseException;
import org.springframework.stereotype.Component;

@Component
public class BasketIDValidator implements Validator<Long> {


    @Override
    public void validate(Long id) throws BaseException {

    }
}

package com.example.orderapiexample.validator;

import com.example.orderapiexample.dto.BasketItemDTO;
import com.example.orderapiexample.exception.BaseException;
import org.springframework.stereotype.Component;

@Component
public class BasketItemValidator implements Validator<BasketItemDTO>{
    @Override
    public void validate(BasketItemDTO basketItemDTO) throws BaseException {

    }
}

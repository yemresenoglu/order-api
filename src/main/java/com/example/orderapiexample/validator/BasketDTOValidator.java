package com.example.orderapiexample.validator;

import com.example.orderapiexample.dto.BasketDTO;
import com.example.orderapiexample.exception.BaseException;
import com.example.orderapiexample.exception.BasketServiceOperationException;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
public class BasketDTOValidator implements Validator<BasketDTO> {


    @Override
    public void validate(BasketDTO basketDTO) throws BaseException {

        if(Objects.isNull(basketDTO.customerID()))
        {
            throw new BasketServiceOperationException.BasketNotValidException("Basket's customer field can not be null or empty.");
        }
        if(Objects.isNull(basketDTO.price()))
        {
            throw new BasketServiceOperationException.BasketNotValidException("Basket's price field can not be null or empty.");
        }
        if(Objects.isNull(basketDTO.discountPrice()))
        {
            throw new BasketServiceOperationException.BasketNotValidException("Basket's discountPrice field can not be null or empty.");
        }
        if(Objects.isNull(basketDTO.taxPrice()))
        {
            throw new BasketServiceOperationException.BasketNotValidException("Basket's taxPrice field can not be null or empty.");
        }
        if(Objects.isNull(basketDTO.shippingPrice()))
        {
            throw new BasketServiceOperationException.BasketNotValidException("Basket's shippingPrice field can not be null or empty.");
        }
        if(Objects.isNull(basketDTO.totalPrice()))
        {
            throw new BasketServiceOperationException.BasketNotValidException("Basket's totalPrice field can not be null or empty.");
        }
    }
}

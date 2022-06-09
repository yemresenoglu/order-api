package com.example.orderapiexample.validator;

import com.example.orderapiexample.dto.CouponDTO;
import com.example.orderapiexample.exception.BaseException;
import org.springframework.stereotype.Component;

@Component
public class CouponDTOValidator implements Validator<CouponDTO>{

    @Override
    public void validate(CouponDTO couponDTO) throws BaseException {

    }
}

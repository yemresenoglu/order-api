package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.CouponDTO;
import com.example.orderapiexample.model.Coupon;


public interface CouponConverter {


    Coupon toCouponConvert(CouponDTO couponDTO);

    CouponDTO toCouponDTOConvert(Coupon coupon);


}

package com.example.orderapiexample.service;

import com.example.orderapiexample.dto.CouponDTO;
import com.example.orderapiexample.model.Coupon;

import java.util.Set;

public interface CouponService {


    void addCoupon(CouponDTO couponDTO);

    CouponDTO getOneCoupon(Long id);

}

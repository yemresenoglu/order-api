package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.CouponDTO;
import com.example.orderapiexample.model.Coupon;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class CouponConverterImpl implements CouponConverter{



    @Override
    public Coupon toCouponConvert(CouponDTO couponDTO) {

        Coupon coupon = new Coupon();

        coupon.setTitle(couponDTO.title());
        coupon.setDescription(couponDTO.description());
        coupon.setStartDate(new Date());
        coupon.setEndDate(couponDTO.endDate());
        coupon.setCode(couponDTO.code());
        coupon.setQuantity(couponDTO.quantity());
        coupon.setDiscountAmount(couponDTO.discountAmount());

        return coupon;
    }

    @Override
    public CouponDTO toCouponDTOConvert(Coupon coupon) {
        return new CouponDTO(coupon.getTitle(),
                coupon.getDescription(),coupon.getStartDate(), coupon.getEndDate(),
                coupon.getCode(), coupon.getQuantity(), coupon.getDiscountAmount() );
    }


}

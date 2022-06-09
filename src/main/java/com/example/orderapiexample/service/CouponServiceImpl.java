package com.example.orderapiexample.service;

import com.example.orderapiexample.converter.CouponConverter;
import com.example.orderapiexample.dto.CouponDTO;
import com.example.orderapiexample.exception.CouponServiceException;
import com.example.orderapiexample.model.Coupon;
import com.example.orderapiexample.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService{

    private final CouponRepository couponRepository;
    private final CouponConverter couponConverter;

    @Override
    public void addCoupon(CouponDTO couponDTO) {

        Coupon coupon = couponConverter.toCouponConvert(couponDTO);
        couponRepository.save(coupon);

    }

    @Override
    public CouponDTO getOneCoupon(Long id) {

        CouponDTO couponDTO = couponConverter
                .toCouponDTOConvert(
                        couponRepository
                                .findById(id)
                                .orElseThrow(()-> new CouponServiceException.CouponNotFoundException("Coupon not found!")));

        return couponDTO;
    }


}

package com.example.orderapiexample.controller;


import com.example.orderapiexample.dto.CouponDTO;
import com.example.orderapiexample.service.CouponService;
import com.example.orderapiexample.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/coupons")
public class CouponController {

    private final CouponService couponService;
    private final Validator<CouponDTO> couponDTOValidator;
    private final Validator<Long> couponIDValidator;


    @PostMapping
    public ResponseEntity<?> createCoupon(@RequestBody CouponDTO couponDTO) {

        couponDTOValidator.validate(couponDTO);
        couponService.addCoupon(couponDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CouponDTO> getOneCoupon(@PathVariable Long id)
    {
        couponIDValidator.validate(id);

        return ResponseEntity.ok(couponService.getOneCoupon(id));
    }



}

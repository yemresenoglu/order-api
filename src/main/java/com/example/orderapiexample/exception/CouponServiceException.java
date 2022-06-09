package com.example.orderapiexample.exception;

public class CouponServiceException {


    public static class CouponNotFoundException extends BaseException {
        public CouponNotFoundException(String message) {
            super(message);
        }
    }

}

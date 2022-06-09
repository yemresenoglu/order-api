package com.example.orderapiexample.exception;

public class BrandServiceOperationException {

    public static class BrandNotValidException extends BaseException
    {
        public BrandNotValidException(String message) {
            super(message);
        }
    }

    public static class BrandNotFoundException extends BaseException {

        public BrandNotFoundException(String message) {
            super(message);
        }
    }
}

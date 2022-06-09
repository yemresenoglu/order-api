package com.example.orderapiexample.exception;

public class OrderServiceException {

    public static class OrderNotFoundException extends BaseException {
        public OrderNotFoundException(String message) {
            super(message);
        }
    }

    public static class OrderNotValidException extends BaseException {
        public OrderNotValidException(String message) {
            super(message);
        }
    }

}

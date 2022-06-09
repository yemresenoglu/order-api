package com.example.orderapiexample.exception;

public class BasketServiceOperationException {

    public static class BasketNotValidException extends BaseException{

        public BasketNotValidException(String message) {
            super(message);
        }
    }

    public static class BasketNotFoundException extends BaseException {
        public BasketNotFoundException(String message) {
            super(message);
        }
    }
}

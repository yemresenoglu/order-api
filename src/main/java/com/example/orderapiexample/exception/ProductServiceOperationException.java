package com.example.orderapiexample.exception;



public class ProductServiceOperationException {

    public static class ProductNotValidException extends BaseException{

        public ProductNotValidException(String message) {
            super(message);
        }
    }

    public static class ProductIDNotValidException extends BaseException{
        public ProductIDNotValidException(String message) {
            super(message);
        }
    }
    public static class ProductNotFoundException extends BaseException{
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

    public static class ProductAlreadyDeletedException extends BaseException {

        public ProductAlreadyDeletedException(String message) {
            super(message);
        }
    }
}

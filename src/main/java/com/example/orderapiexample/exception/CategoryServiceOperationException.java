package com.example.orderapiexample.exception;

public class CategoryServiceOperationException {

    public static class CategoryNotValidException extends BaseException{

        public CategoryNotValidException(String message) {
            super(message);
        }
    }

    public static class CategoryNotFoundException extends BaseException {

        public CategoryNotFoundException(String message) {
            super(message);
        }
    }
}

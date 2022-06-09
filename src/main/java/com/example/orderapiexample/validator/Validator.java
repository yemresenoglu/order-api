package com.example.orderapiexample.validator;

import com.example.orderapiexample.exception.BaseException;
import org.springframework.stereotype.Component;

@Component
public interface Validator<T> {

    void validate(T input) throws BaseException;
}

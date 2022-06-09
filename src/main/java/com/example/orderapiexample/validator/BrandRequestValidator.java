package com.example.orderapiexample.validator;

import com.example.orderapiexample.dto.BrandDTO;
import com.example.orderapiexample.exception.BaseException;
import com.example.orderapiexample.exception.BrandServiceOperationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BrandRequestValidator implements Validator<BrandDTO>{


    @Override
    public void validate(BrandDTO brandDTO) throws BaseException {

        if(Objects.isNull(brandDTO.name())){
            throw new BrandServiceOperationException.BrandNotValidException("Brand's name can not be null or empty.");
        }

    }
}

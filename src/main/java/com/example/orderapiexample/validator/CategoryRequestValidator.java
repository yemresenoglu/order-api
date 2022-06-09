package com.example.orderapiexample.validator;

import com.example.orderapiexample.dto.CategoryDTO;
import com.example.orderapiexample.exception.BaseException;
import com.example.orderapiexample.exception.CategoryServiceOperationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CategoryRequestValidator implements Validator<CategoryDTO>{

    @Override
    public void validate(CategoryDTO categoryDTO) throws BaseException {
        if(Objects.isNull(categoryDTO.name())){
            throw new CategoryServiceOperationException.CategoryNotValidException("Category name can not be null or empty");
        }
    }
}

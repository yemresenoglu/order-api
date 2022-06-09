package com.example.orderapiexample.validator;



import com.example.orderapiexample.dto.ProductDTO;
import com.example.orderapiexample.exception.BaseException;
import com.example.orderapiexample.exception.BrandServiceOperationException;
import com.example.orderapiexample.exception.ProductServiceOperationException;
import com.example.orderapiexample.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ProductRequestValidator implements Validator<ProductDTO>{


    @Override
    public void validate(ProductDTO productDTO) throws BaseException {

        if(Objects.isNull(productDTO.name()))
        {
            throw new ProductServiceOperationException.ProductNotValidException("Product can not be null or empty!");
        }
        if(Objects.isNull(productDTO.price()))
        {
            throw new ProductServiceOperationException.ProductNotValidException("Product can not be null or empty!");
        }
        if(Objects.isNull(productDTO.barcode()))
        {
            throw new ProductServiceOperationException.ProductNotValidException("Product can not be null or empty!");
        }
        if(Objects.isNull(productDTO.image()))
        {
            throw new ProductServiceOperationException.ProductNotValidException("Product can not be null or empty!");
        }
        if(Objects.isNull(productDTO.brandID()))
        {
            throw new ProductServiceOperationException.ProductNotValidException("Product brandID not be null or empty!");
        }
        if(Objects.isNull(productDTO.categoryID()))
        {
            throw new ProductServiceOperationException.ProductNotValidException("Product brandID not be null or empty!");
        }

    }


}

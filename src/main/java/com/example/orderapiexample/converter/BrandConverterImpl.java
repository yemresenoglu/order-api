package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.BrandDTO;
import com.example.orderapiexample.dto.GetBrandResponseDTO;
import com.example.orderapiexample.model.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandConverterImpl implements BrandConverter{


    @Override
    public Brand toBrand(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setName(brandDTO.name());

        return brand;

    }

    @Override
    public GetBrandResponseDTO getBrands(Brand brand) {
        return new GetBrandResponseDTO(brand.getId(), brand.getName());
    }
}

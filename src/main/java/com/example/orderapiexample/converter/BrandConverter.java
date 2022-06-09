package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.BrandDTO;
import com.example.orderapiexample.dto.GetBrandResponseDTO;
import com.example.orderapiexample.model.Brand;


public interface BrandConverter {


    Brand toBrand(BrandDTO brandDTO);

    GetBrandResponseDTO getBrands(Brand brand);
}

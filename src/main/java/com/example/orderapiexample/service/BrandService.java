package com.example.orderapiexample.service;

import com.example.orderapiexample.dto.BrandDTO;
import com.example.orderapiexample.dto.GetBrandResponseDTO;
import com.example.orderapiexample.model.Brand;

import java.util.Collection;

public interface BrandService {

    void createBrand(BrandDTO brandDTO);

    Collection<GetBrandResponseDTO> getBrands();

    Brand getOneBrand(Long brandID);
}

package com.example.orderapiexample.service;

import com.example.orderapiexample.converter.BrandConverter;
import com.example.orderapiexample.dto.BrandDTO;
import com.example.orderapiexample.dto.GetBrandResponseDTO;
import com.example.orderapiexample.exception.BrandServiceOperationException;
import com.example.orderapiexample.model.Brand;
import com.example.orderapiexample.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;
    private final BrandConverter brandConverter;


    @Override
    public void createBrand(BrandDTO brandDTO) {
        Brand brand = brandConverter.toBrand(brandDTO);
        brandRepository.save(brand);

    }

    @Override
    public Collection<GetBrandResponseDTO> getBrands() {
        return brandRepository.findAll().stream().map(brandConverter::getBrands).toList();
    }

    @Override
    public Brand getOneBrand(Long brandID) {
        Brand brand = brandRepository
                .findById(brandID)
                .orElseThrow(()-> new BrandServiceOperationException.BrandNotFoundException("Brand not found!"));
       return brand;

    }
}

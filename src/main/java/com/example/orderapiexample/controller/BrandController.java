package com.example.orderapiexample.controller;

import com.example.orderapiexample.dto.BrandDTO;
import com.example.orderapiexample.dto.GetBrandResponseDTO;
import com.example.orderapiexample.service.BrandService;
import com.example.orderapiexample.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/brands")
public class BrandController {

    private final Validator<BrandDTO> brandRequestValidator;
    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<?> createBrand(@RequestBody BrandDTO brandDTO){

        brandRequestValidator.validate(brandDTO);
        brandService.createBrand(brandDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<GetBrandResponseDTO>> getBrands()
    {
        return ResponseEntity.ok(brandService.getBrands());
    }
}

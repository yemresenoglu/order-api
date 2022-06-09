package com.example.orderapiexample.converter;


import com.example.orderapiexample.dto.GetProductsResponseDTO;
import com.example.orderapiexample.dto.ProductDTO;
import com.example.orderapiexample.model.Product;

public interface ProductConverter {

    Product toProduct(ProductDTO productDTO);

    GetProductsResponseDTO toGetProductsConverter(Product product);

    GetProductsResponseDTO toGetOneProductConverter(Product product);
}

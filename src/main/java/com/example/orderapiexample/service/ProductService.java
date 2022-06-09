package com.example.orderapiexample.service;


import com.example.orderapiexample.dto.GetProductsResponseDTO;
import com.example.orderapiexample.dto.ProductDTO;
import com.example.orderapiexample.model.Product;

import java.util.List;

public interface ProductService {

    void addProduct(ProductDTO productDTO);

    List<GetProductsResponseDTO> getProduct();

    GetProductsResponseDTO getOneProduct(Long id);

    Product getProduct(Long id);

    void deleteProduct(Long id, boolean hardDelete);
}

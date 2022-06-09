package com.example.orderapiexample.service;


import com.example.orderapiexample.converter.ProductConverter;
import com.example.orderapiexample.dto.GetProductsResponseDTO;
import com.example.orderapiexample.dto.ProductDTO;
import com.example.orderapiexample.exception.ProductServiceOperationException;
import com.example.orderapiexample.model.Product;
import com.example.orderapiexample.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductConverter productConverter;
    private final ProductRepository productRepository;

    @Override
    public void addProduct(ProductDTO productDTO) {

        Product product = productConverter.toProduct(productDTO);
        productRepository.save(product);
    }

    @Override
    public List<GetProductsResponseDTO> getProduct() {
        return productRepository.findAll().stream().map(productConverter::toGetProductsConverter).toList();
    }

    @Override
    public GetProductsResponseDTO getOneProduct(Long id) {
        Product product = productRepository.
                findById(id).
                orElseThrow(() -> new ProductServiceOperationException.ProductNotFoundException("Product not found!"));
        return productConverter.toGetOneProductConverter(product);
    }

    @Override
    public Product getProduct(Long id) {
        Product product = productRepository.
                findById(id).
                orElseThrow(() -> new ProductServiceOperationException.ProductNotFoundException("Product not found!"));
        return product;
    }

    @Override
    public void deleteProduct(Long id, boolean hardDelete) {

        Product product = productRepository.
                findById(id).
                orElseThrow(() -> new ProductServiceOperationException.ProductNotFoundException("Product not found!"));

        if(product.isDeleted())
        {
            throw new ProductServiceOperationException.ProductAlreadyDeletedException("Product already deleted!");
        }else if (hardDelete)
        {
                productRepository.deleteById(id);
                product.setDeleted(true);
        }


    }


}

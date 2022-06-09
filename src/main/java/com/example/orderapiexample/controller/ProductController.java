package com.example.orderapiexample.controller;



import com.example.orderapiexample.dto.GetProductsResponseDTO;
import com.example.orderapiexample.dto.ProductDTO;
import com.example.orderapiexample.service.ProductService;
import com.example.orderapiexample.validator.ProductIDValidator;
import com.example.orderapiexample.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final Validator<ProductDTO> productRequestValidator;
    private final ProductIDValidator productIDValidator;



    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO)
    {

        productRequestValidator.validate(productDTO);
        productService.addProduct(productDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<GetProductsResponseDTO>> getProducts()
    {
        return ResponseEntity.ok(productService.getProduct());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id)
    {
        productIDValidator.validate(id);
        return ResponseEntity.ok(productService.getOneProduct(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> hardDeleteProduct(@PathVariable Long id,
                                               @RequestParam(name = "hardDelete", required = true)
                                                       boolean hardDelete )
    {
        productIDValidator.validate(id);
        productService.deleteProduct(id,hardDelete);
        return ResponseEntity.ok().build();
    }





}

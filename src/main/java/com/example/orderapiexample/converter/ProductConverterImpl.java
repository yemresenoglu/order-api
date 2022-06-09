package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.*;
import com.example.orderapiexample.exception.BrandServiceOperationException;
import com.example.orderapiexample.exception.CategoryServiceOperationException;
import com.example.orderapiexample.model.Brand;
import com.example.orderapiexample.model.Category;
import com.example.orderapiexample.model.Product;
import com.example.orderapiexample.service.BrandService;
import com.example.orderapiexample.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ProductConverterImpl implements ProductConverter{

    private final BrandService brandService;
    private final CategoryService categoryService;


    @Override
    public Product toProduct(ProductDTO productDTO) {

        Brand brand = brandService.getOneBrand(productDTO.brandID());
        Category category = categoryService.getOneCategory(productDTO.categoryID());

        Product product = new Product();
        product.setName(productDTO.name());
        product.setPrice(productDTO.price());
        product.setBarcode(productDTO.barcode());
        product.setImage(productDTO.image());

        product.setBrand(brand);
        product.setCategory(category);

        return product;
    }

    @Override
    public GetProductsResponseDTO toGetProductsConverter(Product product) {
        return new GetProductsResponseDTO(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getBarcode(),
                product.getImage(),
                convertProductBrandDTO(product.getBrand()),
                convertProductCategoryDTO(product.getCategory()));
}

    private CategoryDTO convertProductCategoryDTO(Category category) {

        return new CategoryDTO(category.getName());
    }


    private BrandDTO convertProductBrandDTO(Brand brand) {
        return new BrandDTO(brand.getName());
    }

    @Override
    public GetProductsResponseDTO toGetOneProductConverter(Product product) {
        return new GetProductsResponseDTO(product.getId(),
                product.getName(),
                product.getPrice(),
                product.getBarcode(),
                product.getImage(),
                convertProductBrandDTO(product.getBrand()),
                convertProductCategoryDTO(product.getCategory()));
    }


    }

package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.CategoryDTO;
import com.example.orderapiexample.dto.CategoryResponseDTO;
import com.example.orderapiexample.model.Category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CategoryConverterImpl implements CategoryConverter{



    @Override
    public Category createRequestConverter(CategoryDTO categoryDTO) {

        Category category = new Category();
        category.setName(categoryDTO.name());

        return category;
    }

    @Override
    public CategoryResponseDTO getAllRequestConverter(Category category) {
        return new CategoryResponseDTO(category.getId(), category.getName());
    }
}

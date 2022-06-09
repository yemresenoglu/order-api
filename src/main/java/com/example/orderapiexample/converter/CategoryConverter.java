package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.CategoryDTO;
import com.example.orderapiexample.dto.CategoryResponseDTO;
import com.example.orderapiexample.model.Category;

public interface CategoryConverter {

    Category createRequestConverter(CategoryDTO categoryDTO);

    CategoryResponseDTO getAllRequestConverter(Category category);
}

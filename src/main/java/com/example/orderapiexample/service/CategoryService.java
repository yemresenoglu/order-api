package com.example.orderapiexample.service;

import com.example.orderapiexample.dto.CategoryDTO;
import com.example.orderapiexample.dto.CategoryResponseDTO;
import com.example.orderapiexample.model.Category;

import java.util.Collection;

public interface CategoryService {
    
    
    void createCategory(CategoryDTO categoryDTO);

    Collection<CategoryResponseDTO> getAllCategory();

    Category getOneCategory(Long id);
}

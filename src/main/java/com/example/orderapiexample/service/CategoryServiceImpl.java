package com.example.orderapiexample.service;


import com.example.orderapiexample.converter.CategoryConverter;
import com.example.orderapiexample.dto.CategoryDTO;
import com.example.orderapiexample.dto.CategoryResponseDTO;
import com.example.orderapiexample.exception.CategoryServiceOperationException;
import com.example.orderapiexample.model.Category;
import com.example.orderapiexample.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    @Override
    public void createCategory(CategoryDTO categoryDTO) {

        Category category = categoryConverter.createRequestConverter(categoryDTO);
        categoryRepository.save(category);

    }

    @Override
    public Collection<CategoryResponseDTO> getAllCategory() {
        return categoryRepository.
                findAll().stream().map(categoryConverter::getAllRequestConverter).toList();
    }

    @Override
    public Category getOneCategory(Long id) {
        Category category = categoryRepository
                            .findById(id).
                            orElseThrow(()-> new CategoryServiceOperationException.CategoryNotFoundException("Category not found!"));
        return category;
    }


}

package com.example.orderapiexample.controller;

import com.example.orderapiexample.dto.CategoryDTO;
import com.example.orderapiexample.dto.CategoryResponseDTO;
import com.example.orderapiexample.service.CategoryService;
import com.example.orderapiexample.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final Validator<CategoryDTO> categoryRequestValidator;

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO)
    {
        categoryRequestValidator.validate(categoryDTO);
        categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<CategoryResponseDTO>> getAllCategory()
    {
        return ResponseEntity.ok().body(categoryService.getAllCategory());
    }
}

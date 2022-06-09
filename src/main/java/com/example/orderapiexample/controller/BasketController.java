package com.example.orderapiexample.controller;

import com.example.orderapiexample.dto.BasketDTO;
import com.example.orderapiexample.dto.BasketItemDTO;
import com.example.orderapiexample.dto.GetBasketItemsResponseDTO;
import com.example.orderapiexample.service.BasketItemService;
import com.example.orderapiexample.service.BasketService;
import com.example.orderapiexample.validator.BasketIDValidator;
import com.example.orderapiexample.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/baskets")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;
    private final Validator<BasketDTO> basketDTOValidator;
    private final Validator<BasketItemDTO> basketItemValidator;
    private final Validator<Long> basketIdValidator;
    private final BasketItemService basketItemService;


    @PostMapping
    public ResponseEntity<?> createBasket(@RequestBody BasketDTO basketDTO)
    {
        basketDTOValidator.validate(basketDTO);
        basketService.createBasket(basketDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addItem")
    public ResponseEntity<?> addItemToBasket(@RequestBody BasketItemDTO basketItemDTO) {
        basketItemValidator.validate(basketItemDTO);
        basketItemService.addItemToBasket(basketItemDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Collection<GetBasketItemsResponseDTO>> getOneBasketItem(@PathVariable Long id)
    {
        basketIdValidator.validate(id);
        return ResponseEntity.ok(basketItemService.getOneBasketItem(id));
    }
}

package com.example.orderapiexample.service;

import com.example.orderapiexample.dto.BasketItemDTO;
import com.example.orderapiexample.dto.GetBasketItemsResponseDTO;

import java.util.Collection;

public interface BasketItemService {

    void addItemToBasket(BasketItemDTO basketItemDTO);

    Collection<GetBasketItemsResponseDTO> getOneBasketItem(Long id);
}

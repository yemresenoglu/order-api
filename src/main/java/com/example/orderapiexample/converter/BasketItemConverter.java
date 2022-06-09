package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.BasketItemDTO;

import com.example.orderapiexample.dto.GetBasketItemsResponseDTO;
import com.example.orderapiexample.model.BasketItem;



public interface BasketItemConverter {


    BasketItem toAddItemBasket(BasketItemDTO basketItemDTO);

    GetBasketItemsResponseDTO getAllItemOneBasket(BasketItem basketItem);
}

package com.example.orderapiexample.service;

import com.example.orderapiexample.dto.BasketDTO;
import com.example.orderapiexample.model.Basket;

public interface BasketService {
    void createBasket(BasketDTO basketDTO);

    Basket getBasket(Long id);
}

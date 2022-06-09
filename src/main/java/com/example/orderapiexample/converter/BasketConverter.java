package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.BasketDTO;
import com.example.orderapiexample.model.Basket;

public interface BasketConverter {

    Basket toBasket(BasketDTO basketDTO);
}

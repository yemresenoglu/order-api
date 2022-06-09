package com.example.orderapiexample.service;

import com.example.orderapiexample.converter.BasketConverter;
import com.example.orderapiexample.dto.BasketDTO;
import com.example.orderapiexample.exception.BasketServiceOperationException;
import com.example.orderapiexample.model.Basket;
import com.example.orderapiexample.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService{

    private final BasketRepository basketRepository;
    private final BasketConverter basketConverter;

    @Override
    public void createBasket(BasketDTO basketDTO) {

        Basket basket = basketConverter.toBasket(basketDTO);
        basketRepository.save(basket);

    }

    @Override
    public Basket getBasket(Long id) {

        Basket basket = basketRepository
                        .findById(id)
                        .orElseThrow(()-> new BasketServiceOperationException.BasketNotFoundException("Basket not found!"));

        return basket;
    }
}

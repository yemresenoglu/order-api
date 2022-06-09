package com.example.orderapiexample.service;

import com.example.orderapiexample.converter.BasketItemConverter;
import com.example.orderapiexample.dto.BasketItemDTO;
import com.example.orderapiexample.dto.GetBasketItemsResponseDTO;
import com.example.orderapiexample.model.BasketItem;
import com.example.orderapiexample.repository.BasketItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
@RequiredArgsConstructor
public class BasketItemServiceImpl implements BasketItemService{

    private final BasketItemRepository basketItemRepository;
    private final BasketItemConverter basketItemConverter;


    @Override
    public void addItemToBasket(BasketItemDTO basketItemDTO) {

        BasketItem basketItem = basketItemConverter.toAddItemBasket(basketItemDTO);

        basketItemRepository.save(basketItem);
    }

    @Override
    public Collection<GetBasketItemsResponseDTO> getOneBasketItem(Long id) {

        return basketItemRepository
                .findAllOneBasketItem(id)
                .stream().map(basketItemConverter::getAllItemOneBasket).toList();
        
    }
}

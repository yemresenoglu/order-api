package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.BasketItemDTO;
import com.example.orderapiexample.dto.GetBasketItemsResponseDTO;
import com.example.orderapiexample.model.Basket;
import com.example.orderapiexample.model.BasketItem;
import com.example.orderapiexample.model.Product;
import com.example.orderapiexample.service.BasketService;
import com.example.orderapiexample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class BasketItemConverterImpl implements BasketItemConverter{

    private final BasketService basketService;
    private final ProductService productService;


    @Override
    public BasketItem toAddItemBasket(BasketItemDTO basketItemDTO) {

        Basket basket = basketService.getBasket(basketItemDTO.basketId());
        Product product = productService.getProduct(basketItemDTO.productId());


        BasketItem basketItem = new BasketItem();
        basketItem.setBasket(basket);
        basketItem.setProduct(product);
        basketItem.setQuantity(basketItemDTO.quantity());
        basketItem.setPrice(basketItemDTO.price());
        basketItem.setDiscountPrice(basketItemDTO.discountPrice());
        basketItem.setTaxPrice(basketItemDTO.taxPrice());

        return basketItem;
    }

    @Override
    public GetBasketItemsResponseDTO getAllItemOneBasket(BasketItem basketItem) {
        return new GetBasketItemsResponseDTO(basketItem.getBasket().getId(), basketItem.getProduct().getId(),
                basketItem.getQuantity(), basketItem.getPrice(), basketItem.getDiscountPrice(), basketItem.getTaxPrice());
    }


}

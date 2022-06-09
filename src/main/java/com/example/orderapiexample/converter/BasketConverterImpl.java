package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.BasketDTO;
import com.example.orderapiexample.model.Basket;
import com.example.orderapiexample.model.Customer;
import com.example.orderapiexample.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class BasketConverterImpl implements BasketConverter{

    private final CustomerService customerService;

    @Override
    public Basket toBasket(BasketDTO basketDTO) {

        Customer customer = customerService.getOneCustomer(basketDTO.customerID());

        Basket basket = new Basket();
        basket.setCustomer(customer);
        basket.setPrice(basketDTO.price());
        basket.setTaxPrice(basketDTO.taxPrice());
        basket.setDiscountPrice(basketDTO.discountPrice());
        basket.setShippingPrice(basketDTO.shippingPrice());
        basket.setTotalPrice(basketDTO.totalPrice());

        return basket;

    }




}

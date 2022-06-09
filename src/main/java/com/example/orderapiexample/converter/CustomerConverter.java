package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.CustomerDTO;
import com.example.orderapiexample.dto.GetBasketItemsResponseDTO;
import com.example.orderapiexample.dto.GetCustomersResponseDTO;
import com.example.orderapiexample.model.Customer;

public interface CustomerConverter {

    Customer toCustomer(CustomerDTO customerDTO);

   

    CustomerDTO toCreateCustomerRequest(Customer customer);


    GetCustomersResponseDTO toGetCustomersResponse(Customer customer);
}

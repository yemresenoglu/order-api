package com.example.orderapiexample.service;

import com.example.orderapiexample.dto.CustomerDTO;
import com.example.orderapiexample.dto.GetCustomersResponseDTO;
import com.example.orderapiexample.model.Customer;


import java.util.Collection;

public interface CustomerService {


    void create(CustomerDTO customerDTO);

    Collection<GetCustomersResponseDTO> getCustomers();

    CustomerDTO getCustomer(Long id);

    void hardDelete(Long id, boolean hardDelete);

    void softDelete(Long id, boolean softDelete);

    Customer getOneCustomer(Long customerID);
}

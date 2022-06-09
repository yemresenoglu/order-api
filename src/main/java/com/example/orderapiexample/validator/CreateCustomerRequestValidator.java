package com.example.orderapiexample.validator;


import com.example.orderapiexample.dto.CustomerDTO;
import com.example.orderapiexample.exception.BaseException;
import com.example.orderapiexample.exception.CustomerServiceOperationException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CreateCustomerRequestValidator implements Validator<CustomerDTO>{


    @Override
    public void validate(CustomerDTO customerDTO) throws BaseException {
        if(Objects.isNull(customerDTO))
        {
            throw new CustomerServiceOperationException.CustomerNotValidException("Customer can not be null or empty!");
        }
        if(Objects.isNull(customerDTO.userName()))
        {
            throw new CustomerServiceOperationException.CustomerNotValidException("Customer's username can not be null or empty!");
        }
        if(customerDTO.email().isEmpty())
        {
            throw new CustomerServiceOperationException.CustomerNotValidException("Customer's email can not be null or empty!");
        }
        if(Objects.isNull(customerDTO.identity()))
        {
            throw new CustomerServiceOperationException.CustomerNotValidException("Customer's identity can not be null or empty!");
        }
        if(Objects.isNull(customerDTO.gender()))
        {
            throw new CustomerServiceOperationException.CustomerNotValidException("Customer's gender can not be null or empty!");
        }
        if(Objects.isNull(customerDTO.password()))
        {
            throw new CustomerServiceOperationException.CustomerNotValidException("Customer's password can not be null or empty!");
        }

        if(Objects.isNull(customerDTO.customerAddress().city()))
        {
            throw new CustomerServiceOperationException.CustomerNotValidException("Customer's password can not be null or empty!");
        }
        if(Objects.isNull(customerDTO.customerAddress().country()))
        {
            throw new CustomerServiceOperationException.CustomerNotValidException("Customer's password can not be null or empty!");
        }
        if(Objects.isNull(customerDTO.customerAddress().phoneNumber()))
        {
            throw new CustomerServiceOperationException.CustomerNotValidException("Customer's password can not be null or empty!");
        }
        if(Objects.isNull(customerDTO.customerAddress().description()))
        {
            throw new CustomerServiceOperationException.CustomerNotValidException("Customer's password can not be null or empty!");
        }
        if(Objects.isNull(customerDTO.customerAddress().postalCode()))
        {
            throw new CustomerServiceOperationException.CustomerNotValidException("Customer's password can not be null or empty!");
        }

    }


}

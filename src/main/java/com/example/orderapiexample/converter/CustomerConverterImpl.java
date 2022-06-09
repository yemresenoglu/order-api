package com.example.orderapiexample.converter;

import com.example.orderapiexample.dto.CustomerAddressDTO;
import com.example.orderapiexample.dto.CustomerDTO;
import com.example.orderapiexample.dto.GetCustomersResponseDTO;
import com.example.orderapiexample.model.Customer;
import com.example.orderapiexample.model.CustomerAddress;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CustomerConverterImpl implements CustomerConverter{

    @Override
    public Customer toCustomer(CustomerDTO customerDTO) {

        Customer customer = new Customer();
        customer.setUsername(customerDTO.userName());
        customer.setEmail(customerDTO.email());
        customer.setIdentity(customerDTO.identity());
        customer.setGender(customerDTO.gender());
        customer.setPassword(customerDTO.password());
        customer.setCreatedAt(new Date());
        customer.setCreatedBy("Yunus Emre Şenoğlu");



        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress.setPhoneNumber(customerDTO.customerAddress().phoneNumber());
        customerAddress.setCountry(customerDTO.customerAddress().country());
        customerAddress.setCity(customerDTO.customerAddress().city());
        customerAddress.setPostalCode(customerDTO.customerAddress().postalCode());
        customerAddress.setDescription(customerDTO.customerAddress().description());

        customerAddress.setCustomer(customer);
        customer.setCustomerAddress(customerAddress);


        return customer;
    }



    @Override
    public CustomerDTO toCreateCustomerRequest(Customer customer) {
        return new CustomerDTO(customer.getUsername(),
                customer.getEmail(),
                customer.getIdentity(),
                customer.getGender(),
                customer.getPassword(),
                convertCustomerAddressDto(customer.getCustomerAddress()));
    }

    @Override
    public GetCustomersResponseDTO toGetCustomersResponse(Customer customer) {
        return new GetCustomersResponseDTO(customer.getId(), customer.getUsername(), customer.getEmail(), customer.getGender(),
                convertCustomerAddressDto(customer.getCustomerAddress()));
    }

    private CustomerAddressDTO convertCustomerAddressDto(CustomerAddress customerAddress) {

      return new CustomerAddressDTO(customerAddress.getPhoneNumber(),
                customerAddress.getCountry(),
                customerAddress.getCity(),
                customerAddress.getPostalCode(),
                customerAddress.getDescription());
    }


}

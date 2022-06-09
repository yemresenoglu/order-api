package com.example.orderapiexample.service;

import com.example.orderapiexample.converter.CustomerConverter;
import com.example.orderapiexample.dto.CustomerDTO;
import com.example.orderapiexample.dto.GetCustomersResponseDTO;
import com.example.orderapiexample.exception.BaseException;
import com.example.orderapiexample.exception.CustomerServiceOperationException;
import com.example.orderapiexample.model.Customer;
import com.example.orderapiexample.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerConverter customerConverter;
    private final CustomerRepository customerRepository;


    @Override
    public void create(CustomerDTO customerDTO) {

        Customer customer = customerConverter.toCustomer(customerDTO);
        customerRepository.save(customer);

    }

    @Override
    public Collection<GetCustomersResponseDTO> getCustomers() {

        return customerRepository.findAllCustomersByDeleteStatusByJPQL(false).stream().map(customerConverter::toGetCustomersResponse).toList();
    }

    @Override
    public CustomerDTO getCustomer(Long id) throws BaseException {
        Customer customer = customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerServiceOperationException.CustomerNotFoundException("Customer not found"));
        if(customer.isDeleted())
        {
            throw new CustomerServiceOperationException.CustomerNotFoundException("Customer not found");
        }else{
        return customerConverter.toCreateCustomerRequest(customer);}
    }



    @Override
    public void hardDelete(Long id, boolean hardDelete) {


        Customer customer = customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerServiceOperationException.CustomerNotFoundException("Customer not found"));
        if (customer.isDeleted()) {
            throw new CustomerServiceOperationException.CustomerAlreadyDeletedException("Customer already deleted");
        }
        if (hardDelete) {
            customerRepository.delete(customer);
        }

    }

    @Override
    public void softDelete(Long id, boolean softDelete) {
        Customer customer = customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerServiceOperationException.CustomerNotFoundException("Customer not found"));
        if(customer.isDeleted())
        {
            throw new CustomerServiceOperationException.CustomerAlreadyDeletedException("Customer already deleted");
        }
        if(softDelete)
        {
            customer.setDeleted(true);
            customerRepository.save(customer);
        }
    }

    @Override
    public Customer getOneCustomer(Long customerID) {

        Customer customer = customerRepository
                            .findById(customerID)
                            .orElseThrow(
                                    ()-> new CustomerServiceOperationException.CustomerNotFoundException("Customer not found!"));

        return customer;
    }


}

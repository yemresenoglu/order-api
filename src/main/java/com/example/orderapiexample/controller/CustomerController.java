package com.example.orderapiexample.controller;

import com.example.orderapiexample.dto.CustomerDTO;
import com.example.orderapiexample.dto.GetCustomersResponseDTO;
import com.example.orderapiexample.service.CustomerService;

import com.example.orderapiexample.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final Validator<CustomerDTO> createCustomerRequestDTOValidator;
    private final Validator<Long> customerIdValidator;
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CustomerDTO customerDTO)
    {
        createCustomerRequestDTOValidator.validate(customerDTO);
        customerService.create(customerDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<GetCustomersResponseDTO>> getCustomers() {
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id) {
        customerIdValidator.validate(id);
        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> softDeleteCustomer(@PathVariable Long id,
                                                @RequestParam(name = "softDelete", required = false) boolean softDelete ){

        customerIdValidator.validate(id);
        customerService.softDelete(id, softDelete);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> hardDelete(@PathVariable Long id,
                                        @RequestParam(name = "hardDelete", required = false) boolean hardDelete) {
        customerIdValidator.validate(id);
        customerService.hardDelete(id, hardDelete);
        return ResponseEntity.ok().build();
    }




}

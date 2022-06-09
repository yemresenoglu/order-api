package com.example.orderapiexample.dto;

import com.example.orderapiexample.model.Gender;

public record CustomerDTO(String userName,
                          String email,
                          Long identity,
                          Gender gender,
                          String password,
                          CustomerAddressDTO customerAddress) {
}

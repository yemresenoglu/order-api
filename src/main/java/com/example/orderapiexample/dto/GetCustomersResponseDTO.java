package com.example.orderapiexample.dto;

import com.example.orderapiexample.model.Gender;

public record GetCustomersResponseDTO(Long id,
                                      String username,
                                      String email,
                                      Gender gender,
                                      CustomerAddressDTO customerAddressDTO) {
}

package com.example.orderapiexample.dto;

public record CustomerAddressDTO(String phoneNumber,
                                 String country,
                                 String city,
                                 String postalCode,
                                 String description) {
}

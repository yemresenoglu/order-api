package com.example.orderapiexample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class CustomerAddress extends BaseModel {

    private String phoneNumber;
    private String country;
    private String city;
    private String postalCode;
    private String description;

    @OneToOne
    private Customer customer;

}

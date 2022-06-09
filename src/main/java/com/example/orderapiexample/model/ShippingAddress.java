package com.example.orderapiexample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ShippingAddress extends BaseModel {

    private String country;
    private String city;
    private String postalCode;
    private String description;

    @OneToOne
    private Order order;

    @ManyToOne
    private Customer customer;
}
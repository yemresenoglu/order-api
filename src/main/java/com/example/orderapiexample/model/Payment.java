package com.example.orderapiexample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{

    private String type;
    private String cardName;
    private String cardNumber;
    private int expiryMonth;
    private int expiryYear;
    private int cvc;
    private String holderName;

    @OneToOne
    private Order order;

    @ManyToOne
    private Customer customer;

}
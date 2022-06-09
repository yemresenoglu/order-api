package com.example.orderapiexample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class BasketItem extends BaseModel{

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Basket basket;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Product product;

    @Column(nullable = false)
    private BigDecimal quantity;
    @Column(nullable = false)
    private BigDecimal price = BigDecimal.ZERO;
    private BigDecimal discountPrice = BigDecimal.ZERO;
    private BigDecimal taxPrice = BigDecimal.ZERO;

}

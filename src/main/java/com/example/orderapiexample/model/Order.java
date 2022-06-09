package com.example.orderapiexample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Order extends BaseModel{

    private Date orderDate;
    private Date shippingDate;
    private String shippingMethod;
    private String orderStatus;
    private BigDecimal orderPrice = BigDecimal.ZERO;
    private BigDecimal orderDiscountPrice = BigDecimal.ZERO;
    private BigDecimal orderTaxPrice = BigDecimal.ZERO;
    private BigDecimal orderShippingPrice = BigDecimal.ZERO;
    private BigDecimal orderTotalPrice = BigDecimal.ZERO;


    @OneToMany(mappedBy = "order", cascade=CascadeType.ALL)
    private List<OrderItem> orderItemList;

    @OneToOne(mappedBy = "order", cascade=CascadeType.ALL, orphanRemoval = true)
    private ShippingAddress shippingAddress;

    @OneToOne(cascade=CascadeType.ALL)
    private Payment payment;

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Basket basket;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade=CascadeType.ALL)
    private Set<Coupon> couponSet = new HashSet<>();



}

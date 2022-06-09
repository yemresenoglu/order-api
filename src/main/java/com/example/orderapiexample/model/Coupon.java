package com.example.orderapiexample.model;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@Entity
public class Coupon extends BaseModel{

    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String code;
    private int quantity;
    private BigDecimal discountAmount;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Customer customer;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Order order;


}

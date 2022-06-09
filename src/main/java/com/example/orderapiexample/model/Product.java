package com.example.orderapiexample.model;

import lombok.Getter;
import lombok.Setter;



import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Product extends BaseExtendedModel{

    private String name;
    private BigDecimal price;
    private UUID barcode;
    private String image;


    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}

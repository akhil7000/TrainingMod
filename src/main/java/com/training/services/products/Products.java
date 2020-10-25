package com.training.services.products;

import lombok.Getter;

import java.util.List;

@Getter
public class Products {
    private String productID;
    private ProductType productType;
    private List<Offering> offering;
}
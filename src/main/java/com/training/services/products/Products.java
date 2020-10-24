package com.training.services.products;

import lombok.Getter;

import java.util.List;

@Getter
public class Products {
    String productID;
    ProductType productType;
    List<Offering> offering;
}
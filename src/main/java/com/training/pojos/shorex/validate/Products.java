package com.training.pojos.shorex.validate;

import lombok.Data;

import java.util.List;

@Data
public class Products {
    private ProductType productType;
    private String productID;
    private List<Offering> offering;
}

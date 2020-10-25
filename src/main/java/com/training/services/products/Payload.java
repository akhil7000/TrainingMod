package com.training.services.products;

import lombok.Getter;

import java.util.List;

@Getter
public class Payload {
    private Summary summary;
    private List<Products> products;
}
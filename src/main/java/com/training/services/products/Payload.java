package com.training.services.products;

import lombok.Getter;

import java.util.List;

@Getter
public class Payload {
    Summary summary;
    List<Products> products;
}
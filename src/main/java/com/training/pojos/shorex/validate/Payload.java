package com.training.pojos.shorex.validate;

import lombok.Data;

import java.util.List;

@Data
public class Payload {
    private Summary summary;
    private List<Products> products;
}

package com.training.pojos.cat.vote;

import lombok.Setter;

@Setter
public class RequestBody {
    private String image_id;
    private String sub_id;
    private int value;
}
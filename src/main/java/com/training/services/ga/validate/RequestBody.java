package com.training.services.ga.validate;

import com.fasterxml.jackson.annotation.JsonMerge;
import lombok.Setter;

@Setter
public class RequestBody {
    String email;
    String vdsId;
    String lastName;
    String loyaltyId;
    String birthdate;
    Header header;
}
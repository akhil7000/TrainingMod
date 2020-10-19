package com.training.services.ga.validate;

import lombok.Setter;

@Setter
public class RequestBody {
    String email;
    String vdsId;
    String lastName;
    String loyaltyId;
    String birthdate;
    Header header;

    public RequestBody(){
        header = new Header();
    }

    public void setBrand(String r) {
        header.setBrand(r);
    }

    public void setChannel(String web) {
        header.setChannel(web);
    }
}
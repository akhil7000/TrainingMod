package com.training.services.ga.loyalty;

import lombok.Setter;

@Setter
public class RequestBody {
    String vdsId;
    String lastName;
    String loyaltyId;
    String birthdate;
    com.training.services.ga.loyalty.Header header;

    public RequestBody(){
        header = new Header();
    }

    public void setBrand(String brand) {
        header.setBrand(brand);
    }

    public void setChannel(String channel) {
        header.setChannel(channel);
    }
}
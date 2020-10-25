package com.training.services.ga.loyalty;

import lombok.Setter;

@Setter
public class RequestBody {
    private String vdsId;
    private String lastName;
    private String loyaltyId;
    private String birthdate;
    private com.training.services.ga.loyalty.Header header;

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
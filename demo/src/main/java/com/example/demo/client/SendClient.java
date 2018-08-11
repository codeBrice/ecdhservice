package com.example.demo.client;

import com.example.demo.to.SendTo;

public class SendClient {
    private String endpoint;
    public SendClient (String endpoint){ this.endpoint = endpoint; }

    public SendTo Send (final SendTo sendTo){
        sendTo.setAction("Sucess");
        return sendTo;
    }
}

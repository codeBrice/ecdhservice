package com.example.demo.service;

import com.example.demo.client.SendClient;
import com.example.demo.to.SendTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendService {
    private final SendClient sendClient;

    @Autowired
    public SendService (SendClient sendClient){
        this.sendClient = sendClient;
    }

    public SendTo Send (final SendTo sendTo){
        SendTo SendResult = null;
        try {
            SendResult=  sendClient.Send(sendTo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SendResult;
    }
}

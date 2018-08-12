package com.example.demo.service;

import com.example.demo.client.SendClient;
import com.example.demo.to.SendTo;
import com.example.demo.utils.ManageLogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendService {
    private static final Logger log = LoggerFactory. getLogger(SendService.class);
    private final SendClient sendClient;
    ManageLogs manageLogs;
    @Autowired
    public SendService (SendClient sendClient){
        this.sendClient = sendClient;
    }

    public SendTo Send (final SendTo sendTo){
        SendTo SendResult = null;
        try {
            log.debug(manageLogs.PROCESS + "| Call sendClient.Send |"+sendTo.toString());
            SendResult=  sendClient.Send(sendTo);
        } catch (Exception e) {
            log.info(manageLogs.ERROR,e);
            throw e;
        }
        return SendResult;
    }
}

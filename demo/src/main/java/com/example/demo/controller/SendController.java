package com.example.demo.controller;

import com.example.demo.service.SendService;
import com.example.demo.to.SendTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SendController {
    @Autowired
    SendService sendService;

    @RequestMapping(value="/getSend", method= RequestMethod.GET)
    public SendTo getSend(){
        SendTo sendTo = new SendTo();
        sendTo.setAction("send");
        sendTo.setWallet("000D1BAEC8EC208142C99059B393051BAC8380F9B5A2E6B2489A277D81789F3F");
        sendTo.setSource("ban_3e3j5tkog48pnny9dmfzj1r16pg8t1e76dz5tmac6iq689wyjfpi00000000");
        sendTo.setDestination("ban_3e3j5tkog48pnny9dmfzj1r16pg8t1e76dz5tmac6iq689wyjfpi00000000");
        sendTo.setAmount("1000000");

        return sendTo;
    }

    @RequestMapping(value="/send", method = RequestMethod.POST)
    public @ResponseBody SendTo send(@RequestBody SendTo send) {
        SendTo SendResult = null;
        try {
            SendResult =  sendService.Send(send);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SendResult;
    }
}

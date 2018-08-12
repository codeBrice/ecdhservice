package com.example.demo.controller;

import com.example.demo.service.SendService;
import com.example.demo.to.SendTo;
import com.example.demo.utils.ManageLogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 *class responsible for receiving all requests and their information
 */
@RestController
public class SendController {
    private static final Logger log = LoggerFactory. getLogger(SendController.class);

    ManageLogs manageLogs;

    @Autowired
    SendService sendService;

    private HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * test service get
     * @return SendTo json sendTo
     */
    @RequestMapping(value="/getSend", method= RequestMethod.GET)
    public SendTo getSend(){
        log.info(manageLogs.START);

        log.debug(manageLogs.PROCESS);
        SendTo sendTo = new SendTo();
        sendTo.setAction("send");
        sendTo.setWallet("000D1BAEC8EC208142C99059B393051BAC8380F9B5A2E6B2489A277D81789F3F");
        sendTo.setSource("ban_3e3j5tkog48pnny9dmfzj1r16pg8t1e76dz5tmac6iq689wyjfpi00000000");
        sendTo.setDestination("ban_3e3j5tkog48pnny9dmfzj1r16pg8t1e76dz5tmac6iq689wyjfpi00000000");
        sendTo.setAmount("1000000");

        log.info(manageLogs.SUCCESS);
        return sendTo;
    }

    /**
     * method responsible for receiving the json and pass it to the service
     * @param send json of all the parameters necessary for the service
     * @return SendTo json with the final answer
     */
    @RequestMapping(value="/send", method = RequestMethod.POST)
    public @ResponseBody SendTo send(@RequestBody SendTo send) {
        log.info(manageLogs.START+"|"+manageLogs.getIpHost()+"|"+manageLogs.getIpUser(request));
        SendTo SendResult = null;
        try {
            log.debug(manageLogs.PROCESS + "| Call sendService.Send |"+send.toString());
            SendResult =  sendService.Send(send);
            log.info(manageLogs.SUCCESS+"|"+manageLogs.getIpHost()+"|"+manageLogs.getIpUser(request));
        } catch (Exception e) {
            log.error(manageLogs.ERROR+"|"+manageLogs.getIpHost()+"|"+manageLogs.getIpUser(request),e);
        }
        return SendResult;
    }
}

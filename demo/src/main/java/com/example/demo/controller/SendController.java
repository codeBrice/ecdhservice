package com.example.demo.controller;

import com.example.demo.service.SendService;
import com.example.demo.to.SendTo;
import com.example.demo.utils.ManageLogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
/**
 * class responsible for receiving all requests and their information.
 *
 * @since 1.0
 * @author teamJeb
 * @version 1.0
 */
@RestController
public class SendController {
    /**
     *  varresponsible for calling the types of logs.
     */
    private static final Logger log = LoggerFactory.getLogger(SendController.class);
    /**
     * where are the states of the transaction and other utilities.
     */
    private ManageLogs manageLogs;

    /**
     * call the methods of sending the transaction.
     */
    @Autowired
    private SendService sendService;
    /**
     *to access the HttpRequest information as the ip.
     */
    private HttpServletRequest request;

    /**
     * everyone who calls this service will get their information.
     * @param request their information.
     */
    @Autowired
    private void setRequest(final HttpServletRequest request) {
        this.request = request;
    }

    /**
     * test service get.
     * @return SendTo json sendTo.
     */
    @RequestMapping(value = "/getSend", method = RequestMethod.GET)
    public SendTo getSend() {
        log.info(manageLogs.START);

        log.debug(manageLogs.PROCESS);
        final SendTo sendTo = new SendTo();
        sendTo.setAction("send");
        sendTo.setWallet("000D1BAEC8EC208142C99059B393051BAC8380F9B5A2E6B2489A277D81789F3F");
        sendTo.setSource("ban_3e3j5tkog48pnny9dmfzj1r16pg8t1e76dz5tmac6iq689wyjfpi00000000");
        sendTo.setDestination("ban_3e3j5tkog48pnny9dmfzj1r16pg8t1e76dz5tmac6iq689wyjfpi00000000");
        sendTo.setAmount("1000000");

        log.info(manageLogs.SUCCESS);
        return sendTo;
    }

    /**
     * method responsible for receiving the json and pass it to the service.
     * @param send json of all the parameters necessary for the service.
     * @return SendTo json with the final answer.
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public @ResponseBody SendTo send(@RequestBody final SendTo send) {
        log.info(manageLogs.START.concat("|").concat(manageLogs.getIpHost()).concat("|").concat(manageLogs.getIpUser(request)));
        SendTo sendResult = null;
        try {
            log.debug(manageLogs.PROCESS.concat("| Call sendService.send |").concat(send.toString()));
            sendResult =  sendService.send(send);
            log.info(manageLogs.SUCCESS.concat("|").concat(manageLogs.getIpHost()).concat("|").concat(manageLogs.getIpUser(request)));
        } catch (Exception e) {
            log.error(manageLogs.ERROR.concat("|").concat(manageLogs.getIpHost()).concat("|").concat(manageLogs.getIpUser(request)), e);
        }
        return sendResult;
    }
}

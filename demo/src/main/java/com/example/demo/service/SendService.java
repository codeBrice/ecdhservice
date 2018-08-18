package com.example.demo.service;

import com.example.demo.client.SendClient;
import com.example.demo.to.SendTo;
import com.example.demo.utils.ManageLogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * class responsible for all business rules before calling services or databases.
 *
 * @since 1.0
 * @author teamJeb
 * @version 1.0
 */
@Service
public class SendService {
    /**
     *  var responsible for calling the types of logs.
     */
    private static final Logger log = LoggerFactory. getLogger(SendService.class);
    /**
     *  variable that will have the necessary methods to call the service.
     */
    private final SendClient sendClient;
    /**
     * where are the states of the transaction and other utilities.
     */
    private ManageLogs manageLogs;
    /**
     * endClient is stored in variable.
     * @param sendClient SendClient
     */
    @Autowired
    public SendService(final SendClient sendClient) {
        this.sendClient = sendClient;
    }

    /**
     *method that has the business rules and call the banana service send.
     * if necessary a Repository class is added for connections to database.
     * @param sendTo json of all the parameters necessary for the service.
     * @return SendTo json with the final answer.
     */
    public SendTo send(final SendTo sendTo) {
        SendTo sendResult = null;
        try {
            log.debug(manageLogs.PROCESS.concat("| Call sendClient.send |").concat(sendTo.toString()));
            sendResult =  sendClient.send(sendTo);
        } catch (Exception e) {
            log.info(manageLogs.ERROR, e);
            throw e;
        }
        return sendResult;
    }
}

package com.example.demo.client;

import com.example.demo.to.SendTo;
import com.example.demo.utils.ManageLogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * class responsible for connecting external services with our service
 */
public class SendClient {
    private static final Logger log = LoggerFactory. getLogger(SendClient.class);

    ManageLogs manageLogs;
    private String endpoint;
    public SendClient (String endpoint){ this.endpoint = endpoint; }

    /**
     *method responsible for calling the banana external service send
     * @param sendTo json of all the parameters necessary for the service
     * @return SendTo json with the final answer
     */
    public SendTo Send (final SendTo sendTo){
        try {
            log.debug(manageLogs.PROCESS + "| Call Service Banano |"+sendTo.toString());
            if (true) {
                log.debug(manageLogs.SUCCESS+"| Service Banano");
                sendTo.setAction("Success");
            } else {
                log.debug(manageLogs.NOSUCCESS+"| Service Banano");
                sendTo.setAction("No Success");
            }
            return sendTo;
        } catch (Exception e) {
            log.info(manageLogs.ERROR,e);
            throw e;
        }
    }
}

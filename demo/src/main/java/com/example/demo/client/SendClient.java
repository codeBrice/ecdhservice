package com.example.demo.client;

import com.example.demo.to.SendTo;
import com.example.demo.utils.ManageLogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * class responsible for connecting external services with our service.
 *
 * @since 1.0
 * @author teamJeb
 * @version 1.0
 */
public class SendClient {
    /**
     *  var responsible for calling the types of logs.
     */
    private static final Logger log = LoggerFactory. getLogger(SendClient.class);
    /**
     * where are the states of the transaction and other utilities.
     */
    private ManageLogs manageLogs;
    /**
     * has the option of the service to connect.
     */
    private String endpoint;

    /**
     * where the endpoint is stored in variable.
     * @param endpoint url service.
     */
    public SendClient(final String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     *method responsible for calling the banana external service send.
     * @param sendTo json of all the parameters necessary for the service.
     * @return SendTo json with the final answer.
     */
    public SendTo send(final SendTo sendTo) {
        try {
            log.debug(manageLogs.PROCESS.concat("| Call Service Banano |").concat(sendTo.toString()));
            if (true) {
                log.debug(manageLogs.SUCCESS.concat("| Service Banano"));
                sendTo.setAction("Success");
            } else {
                log.debug(manageLogs.NOSUCCESS.concat("| Service Banano"));
                sendTo.setAction("No Success");
            }
            return sendTo;
        } catch (Exception e) {
            log.info(manageLogs.ERROR, e);
            throw e;
        }
    }
}

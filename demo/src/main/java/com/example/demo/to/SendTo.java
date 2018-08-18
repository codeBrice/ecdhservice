package com.example.demo.to;

/**
 * all the input information.
 *
 * @since 1.0
 * @author teamJeb
 * @version 1.0
 */
public class SendTo {
    /**
     * requested action.
     */
    private String action;
    /**
     * wallet.
     */
    private String wallet;
    /**
     * source to which the bananos will be debited.
     */
    private String source;
    /**
     * source to which the bananas will be added.
     */
    private String destination;
    /**
     * amount to transfer.
     */
    private String amount;

    /**
     * obtain action.
     * @return String
     */
    public String getAction() {
        return action;
    }

    /**
     * save action.
     * @param action String
     */
    public void setAction(final String action) {
        this.action = action;
    }

    /**
     * obtain wallet.
     * @return String
     */
    public String getWallet() {
        return wallet;
    }

    /**
     * save wallet.
     * @param wallet String
     */
    public void setWallet(final String wallet) {
        this.wallet = wallet;
    }

    /**
     * obtain source.
     * @return String
     */
    public String getSource() {
        return source;
    }

    /**
     * save source.
     * @param source String
     */
    public void setSource(final String source) {
        this.source = source;
    }

    /**
     * obtain destination.
     * @return String
     */
    public String getDestination() {
        return destination;
    }

    /**
     * save destination.
     * @param destination String
     */
    public void setDestination(final String destination) {
        this.destination = destination;
    }

    /**
     * obtain amount.
     * @return String
     */
    public String getAmount() {
        return amount;
    }

    /**
     * save amount.
     * @param amount String
     */
    public void setAmount(final String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SendTo{"
                + "action='" + action + '\''
                + ", wallet='" + wallet + '\''
                + ", source='" + source + '\''
                + ", destination='" + destination + '\''
                + ", amount='" + amount + '\''
                + '}';
    }
}

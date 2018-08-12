package com.example.demo.to;


public class SendTo
{
    /**
     * requested action
     */
    private String action;
    /**
     * wallet
     */
    private String wallet;
    /**
     * source to which the bananos will be debited
     */
    private String source;
    /**
     * source to which the bananas will be added
     */
    private String destination;
    /**
     * amount to transfer
     */
    private String amount;

    public String getAmount ()
    {
        return amount;
    }

    public void setAmount (String amount)
    {
        this.amount = amount;
    }

    public String getSource ()
    {
        return source;
    }

    public void setSource (String source)
    {
        this.source = source;
    }

    public String getAction ()
    {
        return action;
    }

    public void setAction (String action)
    {
        this.action = action;
    }

    public String getWallet ()
    {
        return wallet;
    }

    public void setWallet (String wallet)
    {
        this.wallet = wallet;
    }

    public String getDestination ()
    {
        return destination;
    }

    public void setDestination (String destination)
    {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "SendTo{" +
                "action='" + action + '\'' +
                ", wallet='" + wallet + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}

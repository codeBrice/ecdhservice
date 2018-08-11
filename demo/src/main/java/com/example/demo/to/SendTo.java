package com.example.demo.to;


public class SendTo
{
    private String action;
    private String wallet;
    private String source;
    private String destination;
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
    public String toString()
    {
        return "ClassPojo [amount = "+amount+", source = "+source+", action = "+action+", wallet = "+wallet+", destination = "+destination+"]";
    }
}

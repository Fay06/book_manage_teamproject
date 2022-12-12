package com.nobug.nobug_teamproject.models;

public class Client {
    private String clientName;

    private int clientID;

    public Client(int clientID,String clientName) {
        this.clientID = clientID;
        this.clientName = clientName;
    }

    public Client() {
        super();
    }

    public int getClientID() {return clientID;}

    public void setClientID(int clientID) {this.clientID=clientID; }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}

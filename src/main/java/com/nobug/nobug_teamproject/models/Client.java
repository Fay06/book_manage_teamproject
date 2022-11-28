package com.nobug.nobug_teamproject.models;

public class Client {
    private String clientName;

    public Client(String clientName) {
        this.clientName = clientName;
    }

    public Client() {
        super();
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}

package com.miguel.ubots_test.model;

public class Solicitation {
    private String type;
    private String clientId;

    public Solicitation(String type, String clientId) {
        this.type = type;
        this.clientId = clientId;
    }

    public String getType() {
        return type;
    }

    public String getClientId() {
        return clientId;
    }
}



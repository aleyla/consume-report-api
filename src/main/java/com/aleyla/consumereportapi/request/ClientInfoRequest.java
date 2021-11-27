package com.aleyla.consumereportapi.request;

import javax.validation.constraints.NotBlank;

public class ClientInfoRequest {

    @NotBlank
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}

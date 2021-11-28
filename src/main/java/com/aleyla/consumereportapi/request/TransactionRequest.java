package com.aleyla.consumereportapi.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TransactionRequest {

    @NotBlank
    private String transactionId;

}

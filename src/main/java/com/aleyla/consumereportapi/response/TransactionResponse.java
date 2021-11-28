package com.aleyla.consumereportapi.response;

import com.aleyla.consumereportapi.dto.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponse {

    private List<FX> fx;

    private List<CustomerInfo> customerInfo;

    private List<Acquirer> acquirerTransactions;

    private List<Merchant> merchant;

    private List<Transaction> transactions;
}

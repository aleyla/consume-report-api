package com.aleyla.consumereportapi.response;

import com.aleyla.consumereportapi.dto.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponse {

    private List<FX> fx;

    private List<CustomerInfo> customerInfo;

    private List<Acquirer> acquirerTransactions;

    private List<Merchant> merchant;

    private List<Transaction> merchantTransactions;

    public List<FX> getFx() {
        return fx;
    }

    public void setFx(List<FX> fx) {
        this.fx = fx;
    }

    public List<CustomerInfo> getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(List<CustomerInfo> customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<Acquirer> getAcquirerTransactions() {
        return acquirerTransactions;
    }

    public void setAcquirerTransactions(List<Acquirer> acquirerTransactions) {
        this.acquirerTransactions = acquirerTransactions;
    }

    public List<Merchant> getMerchant() {
        return merchant;
    }

    public void setMerchant(List<Merchant> merchant) {
        this.merchant = merchant;
    }

    public List<Transaction> getMerchantTransactions() {
        return merchantTransactions;
    }

    public void setMerchantTransactions(List<Transaction> merchantTransactions) {
        this.merchantTransactions = merchantTransactions;
    }
}

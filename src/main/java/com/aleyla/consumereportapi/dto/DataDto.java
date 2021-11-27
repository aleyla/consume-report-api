package com.aleyla.consumereportapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDto {

    private List<FX> fx;

    private List<CustomerInfo> customerInfo;

    private List<Merchant> merchant;

    private List<IPN> ipn;

    private List<Transaction> transaction;

    private List<Acquirer> acquirer;

    private Boolean refundable;

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

    public List<Merchant> getMerchant() {
        return merchant;
    }

    public void setMerchant(List<Merchant> merchant) {
        this.merchant = merchant;
    }

    public List<IPN> getIpn() {
        return ipn;
    }

    public void setIpn(List<IPN> ipn) {
        this.ipn = ipn;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public List<Acquirer> getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(List<Acquirer> acquirer) {
        this.acquirer = acquirer;
    }

    public Boolean getRefundable() {
        return refundable;
    }

    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
    }
}

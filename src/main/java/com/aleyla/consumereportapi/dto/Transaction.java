package com.aleyla.consumereportapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    private MerchantTransaction merchant;

    public MerchantTransaction getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantTransaction merchant) {
        this.merchant = merchant;
    }
}

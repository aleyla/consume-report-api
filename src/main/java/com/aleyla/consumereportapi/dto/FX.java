package com.aleyla.consumereportapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FX {

    private FXMerchant merchant;

    public FXMerchant getMerchant() {
        return merchant;
    }

    public void setMerchant(FXMerchant merchant) {
        this.merchant = merchant;
    }
}

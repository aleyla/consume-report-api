package com.aleyla.consumereportapi.dto;

import com.aleyla.consumereportapi.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FXMerchant {

    private BigDecimal originalAmount;

    private Currency originalCurrency;

    public BigDecimal getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(BigDecimal originalAmount) {
        this.originalAmount = originalAmount;
    }

    public Currency getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(Currency originalCurrency) {
        this.originalCurrency = originalCurrency;
    }
}

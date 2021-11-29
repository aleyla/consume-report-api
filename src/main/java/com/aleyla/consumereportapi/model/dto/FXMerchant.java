package com.aleyla.consumereportapi.model.dto;

import com.aleyla.consumereportapi.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FXMerchant {

    private BigDecimal originalAmount;

    private Currency originalCurrency;

}

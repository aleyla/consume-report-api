package com.aleyla.consumereportapi.model.dto;

import com.aleyla.consumereportapi.enums.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto {

    private Integer count = 0;

    private BigDecimal total = BigDecimal.ZERO;

    private Currency currency;
}

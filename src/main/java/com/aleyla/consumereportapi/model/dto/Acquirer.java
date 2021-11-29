package com.aleyla.consumereportapi.model.dto;

import com.aleyla.consumereportapi.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Acquirer {

    private Long id;

    private String name;

    private String code;

    private PaymentMethod type;
}

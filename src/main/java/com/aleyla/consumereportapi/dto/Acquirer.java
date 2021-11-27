package com.aleyla.consumereportapi.dto;

import com.aleyla.consumereportapi.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Acquirer {

    private Long id;

    private String name;

    private String code;

    private PaymentMethod type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public PaymentMethod getType() {
        return type;
    }

    public void setType(PaymentMethod type) {
        this.type = type;
    }
}

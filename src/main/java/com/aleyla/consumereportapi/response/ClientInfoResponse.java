package com.aleyla.consumereportapi.response;

import com.aleyla.consumereportapi.dto.CustomerInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientInfoResponse {

    private CustomerInfo customerInfo;

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }
}

package com.aleyla.consumereportapi.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Agent {

    private Long id;

    private String customerIp;

    private String customerUserAgent;

    private String merchantIp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public void setCustomerIp(String customerIp) {
        this.customerIp = customerIp;
    }

    public String getCustomerUserAgent() {
        return customerUserAgent;
    }

    public void setCustomerUserAgent(String customerUserAgent) {
        this.customerUserAgent = customerUserAgent;
    }

    public String getMerchantIp() {
        return merchantIp;
    }

    public void setMerchantIp(String merchantIp) {
        this.merchantIp = merchantIp;
    }
}

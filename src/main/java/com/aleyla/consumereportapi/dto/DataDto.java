package com.aleyla.consumereportapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDto {

    private List<FX> fx;

    private List<CustomerInfo> customerInfo;

    private List<Merchant> merchant;

    private List<IPN> ipn;

    private List<MerchantTransaction> transaction;

    private List<Acquirer> acquirer;

    private Boolean refundable;
}

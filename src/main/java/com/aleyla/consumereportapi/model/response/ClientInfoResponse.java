package com.aleyla.consumereportapi.model.response;

import com.aleyla.consumereportapi.model.dto.CustomerInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientInfoResponse {

    private CustomerInfo customerInfo;

}

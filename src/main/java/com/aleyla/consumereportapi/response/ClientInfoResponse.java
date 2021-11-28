package com.aleyla.consumereportapi.response;

import com.aleyla.consumereportapi.dto.CustomerInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientInfoResponse {

    private CustomerInfo customerInfo;

}

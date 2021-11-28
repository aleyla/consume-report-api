package com.aleyla.consumereportapi.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class ClientInfoRequest {

    @NotBlank
    private String transactionId;

}

package com.aleyla.consumereportapi.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Agent {

    private Long id;

    private String customerIp;

    private String customerUserAgent;

    private String merchantIp;
}

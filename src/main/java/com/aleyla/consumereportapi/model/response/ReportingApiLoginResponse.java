package com.aleyla.consumereportapi.model.response;

import com.aleyla.consumereportapi.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportingApiLoginResponse {

    private String token;

    private Status status;

}

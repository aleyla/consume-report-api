package com.aleyla.consumereportapi.response;

import com.aleyla.consumereportapi.dto.ResponseDto;
import com.aleyla.consumereportapi.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionReportResponse {

    private Status status;

    private List<ResponseDto> response;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ResponseDto> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseDto> response) {
        this.response = response;
    }
}

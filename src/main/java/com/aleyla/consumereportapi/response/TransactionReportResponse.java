package com.aleyla.consumereportapi.response;

import com.aleyla.consumereportapi.dto.ResponseDto;
import com.aleyla.consumereportapi.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionReportResponse {

    private Status status;

    private List<ResponseDto> response = new ArrayList<>();

}

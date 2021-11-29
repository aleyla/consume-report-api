package com.aleyla.consumereportapi.model.response;

import com.aleyla.consumereportapi.model.dto.ResponseDto;
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

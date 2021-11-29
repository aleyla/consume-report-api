package com.aleyla.consumereportapi.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionReportRequest {

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fromDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate toDate;

    private Long merchantId;

    private Long acquirerId;

}

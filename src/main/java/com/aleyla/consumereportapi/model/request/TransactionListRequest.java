package com.aleyla.consumereportapi.model.request;

import com.aleyla.consumereportapi.enums.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionListRequest {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;

    private Status status;

    private Operation operation;

    private Integer merchantId;

    private Integer acquirerId;

    private PaymentMethod paymentMethod;

    private ErrorCode errorCode;

    private FilterField filterField;

    private String filterValue;

    private int page;

}

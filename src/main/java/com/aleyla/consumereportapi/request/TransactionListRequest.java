package com.aleyla.consumereportapi.request;

import com.aleyla.consumereportapi.enums.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TransactionListRequest {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

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

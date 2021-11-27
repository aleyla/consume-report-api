package com.aleyla.consumereportapi.request;

import com.aleyla.consumereportapi.enums.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

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

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(Integer acquirerId) {
        this.acquirerId = acquirerId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public FilterField getFilterField() {
        return filterField;
    }

    public void setFilterField(FilterField filterField) {
        this.filterField = filterField;
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}

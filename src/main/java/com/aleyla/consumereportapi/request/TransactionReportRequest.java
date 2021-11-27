package com.aleyla.consumereportapi.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TransactionReportRequest {

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;

    private Integer merchant;

    private Integer acquirer;

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Integer getMerchant() {
        return merchant;
    }

    public void setMerchant(Integer merchant) {
        this.merchant = merchant;
    }

    public Integer getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(Integer acquirer) {
        this.acquirer = acquirer;
    }
}

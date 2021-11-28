package com.aleyla.consumereportapi.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class TransactionReportRequest {

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;

    private Long merchant;

    private Long acquirer;

}

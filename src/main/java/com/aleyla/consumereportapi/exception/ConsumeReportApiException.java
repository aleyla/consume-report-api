package com.aleyla.consumereportapi.exception;

import com.aleyla.consumereportapi.enums.ExceptionCode;

import java.util.function.Supplier;

public class ConsumeReportApiException extends RuntimeException implements Supplier<ConsumeReportApiException> {

    private final ExceptionCode errorCode;


    public ConsumeReportApiException(String message, ExceptionCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    @Override
    public ConsumeReportApiException get() {
        return this;
    }

    public ExceptionCode getErrorCode() {
        return errorCode;
    }
}

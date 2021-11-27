package com.aleyla.consumereportapi.exception;

import com.aleyla.consumereportapi.enums.ErrorCodeEnum;

import java.util.function.Supplier;

public class ConsumeReportApiException extends RuntimeException implements Supplier<ConsumeReportApiException> {

    private final ErrorCodeEnum errorCode;


    public ConsumeReportApiException(String message, ErrorCodeEnum errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    @Override
    public ConsumeReportApiException get() {
        return this;
    }

    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }
}

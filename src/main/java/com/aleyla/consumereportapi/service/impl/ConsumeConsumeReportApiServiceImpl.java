package com.aleyla.consumereportapi.service.impl;

import com.aleyla.consumereportapi.client.ReportingApiClient;
import com.aleyla.consumereportapi.enums.ErrorCodeEnum;
import com.aleyla.consumereportapi.exception.ConsumeReportApiException;
import com.aleyla.consumereportapi.request.*;
import com.aleyla.consumereportapi.response.*;
import com.aleyla.consumereportapi.service.ConsumeReportApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumeConsumeReportApiServiceImpl implements ConsumeReportApiService {

    private final ReportingApiClient client;

    @Override
    public ReportingApiLoginResponse login(LoginRequest request) {
        return client.login(request)
                     .orElseThrow(new ConsumeReportApiException("Check login info", ErrorCodeEnum.EXTERNAL_SERVICE_ERROR));
    }

    @Override
    public TransactionReportResponse getReport(TransactionReportRequest request) {
        String token = "";
        return client.getReport(request, token)
                     .orElseThrow(new ConsumeReportApiException("Check request info", ErrorCodeEnum.EXTERNAL_SERVICE_ERROR));
    }

    @Override
    public TransactionListResponse getList(TransactionListRequest request) {
        String token = "";
        return client.getList(request, token).orElseThrow(new ConsumeReportApiException("Check request info", ErrorCodeEnum.EXTERNAL_SERVICE_ERROR));

    }

    @Override
    public TransactionResponse getTransaction(TransactionRequest request) {
        String token = "";
        return client.getTransaction(request, token)
                     .orElseThrow(new ConsumeReportApiException("Check request info", ErrorCodeEnum.EXTERNAL_SERVICE_ERROR));

    }

    @Override
    public ClientInfoResponse getClientInfo(ClientInfoRequest request) {
        String token = "";
        return client.getClientInfo(request, token)
                     .orElseThrow(new ConsumeReportApiException("Check request info", ErrorCodeEnum.EXTERNAL_SERVICE_ERROR));

    }
}

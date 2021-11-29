package com.aleyla.consumereportapi.service;

import com.aleyla.consumereportapi.model.request.*;
import com.aleyla.consumereportapi.model.response.*;

public interface ConsumeReportApiService {

    ReportingApiLoginResponse login(LoginRequest request);

    TransactionReportResponse getReport(TransactionReportRequest request);

    TransactionListResponse getList(TransactionListRequest request);

    TransactionResponse getTransaction(TransactionRequest request);

    ClientInfoResponse getClientInfo(ClientInfoRequest request);
}

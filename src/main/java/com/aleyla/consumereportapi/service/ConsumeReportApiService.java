package com.aleyla.consumereportapi.service;

import com.aleyla.consumereportapi.request.*;
import com.aleyla.consumereportapi.response.*;

public interface ConsumeReportApiService {

    ReportingApiLoginResponse login(LoginRequest request);

    TransactionReportResponse getReport(TransactionReportRequest request);

    TransactionListResponse getList(TransactionListRequest request);

    TransactionResponse getTransaction(TransactionRequest request);

    ClientInfoResponse getClientInfo(ClientInfoRequest request);
}

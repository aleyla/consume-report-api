package com.aleyla.consumereportapi.service;

import com.aleyla.consumereportapi.request.ClientInfoRequest;
import com.aleyla.consumereportapi.request.TransactionListRequest;
import com.aleyla.consumereportapi.request.TransactionReportRequest;
import com.aleyla.consumereportapi.request.TransactionRequest;
import com.aleyla.consumereportapi.response.ClientInfoResponse;
import com.aleyla.consumereportapi.response.TransactionListResponse;
import com.aleyla.consumereportapi.response.TransactionReportResponse;
import com.aleyla.consumereportapi.response.TransactionResponse;

public interface TransactionService {

    ClientInfoResponse getClient(ClientInfoRequest request);

    TransactionResponse getTransaction(TransactionRequest request);

    TransactionListResponse getList(TransactionListRequest request);

    TransactionReportResponse getReport(TransactionReportRequest request);

}

package com.aleyla.consumereportapi.service;

import com.aleyla.consumereportapi.model.entity.TransactionEntity;
import com.aleyla.consumereportapi.model.request.ClientInfoRequest;
import com.aleyla.consumereportapi.model.request.TransactionListRequest;
import com.aleyla.consumereportapi.model.request.TransactionReportRequest;
import com.aleyla.consumereportapi.model.request.TransactionRequest;
import com.aleyla.consumereportapi.model.response.ClientInfoResponse;
import com.aleyla.consumereportapi.model.response.TransactionListResponse;
import com.aleyla.consumereportapi.model.response.TransactionReportResponse;
import com.aleyla.consumereportapi.model.response.TransactionResponse;

import java.util.List;

public interface TransactionService {

    ClientInfoResponse getClient(ClientInfoRequest request);

    TransactionResponse getTransaction(TransactionRequest request);

    TransactionListResponse getList(TransactionListRequest request);

    List<TransactionEntity> getAll();

    TransactionReportResponse getReport(TransactionReportRequest request);

}

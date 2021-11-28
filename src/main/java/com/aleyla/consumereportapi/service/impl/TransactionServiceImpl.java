package com.aleyla.consumereportapi.service.impl;

import com.aleyla.consumereportapi.dto.FX;
import com.aleyla.consumereportapi.dto.FXMerchant;
import com.aleyla.consumereportapi.dto.ResponseDto;
import com.aleyla.consumereportapi.entity.TransactionEntity;
import com.aleyla.consumereportapi.enums.Currency;
import com.aleyla.consumereportapi.enums.ErrorCodeEnum;
import com.aleyla.consumereportapi.enums.Status;
import com.aleyla.consumereportapi.exception.ConsumeReportApiException;
import com.aleyla.consumereportapi.mapper.AcquirerMapper;
import com.aleyla.consumereportapi.mapper.CustomerInfoMapper;
import com.aleyla.consumereportapi.mapper.MerchantMapper;
import com.aleyla.consumereportapi.mapper.TransactionMapper;
import com.aleyla.consumereportapi.repository.transaction.TransactionRepository;
import com.aleyla.consumereportapi.repository.transaction.TransactionSpecification;
import com.aleyla.consumereportapi.request.ClientInfoRequest;
import com.aleyla.consumereportapi.request.TransactionListRequest;
import com.aleyla.consumereportapi.request.TransactionReportRequest;
import com.aleyla.consumereportapi.request.TransactionRequest;
import com.aleyla.consumereportapi.response.ClientInfoResponse;
import com.aleyla.consumereportapi.response.TransactionListResponse;
import com.aleyla.consumereportapi.response.TransactionReportResponse;
import com.aleyla.consumereportapi.response.TransactionResponse;
import com.aleyla.consumereportapi.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final CustomerInfoMapper customerInfoMapper;
    private final MerchantMapper merchantMapper;
    private final AcquirerMapper acquirerMapper;
    private final TransactionMapper transactionMapper;


    @Override
    public ClientInfoResponse getClient(ClientInfoRequest request) {
        TransactionEntity byTransactionId = repository.findByIdFetchCustomer(Long.valueOf(request.getTransactionId()))
                                                      .orElseThrow(new ConsumeReportApiException("TransactionId", ErrorCodeEnum.BAD_REQUEST_ERROR));
        return customerInfoMapper.map(byTransactionId.getCustomerInfo());
    }

    @Override
    public TransactionResponse getTransaction(TransactionRequest request) {
        TransactionEntity byTransactionId = repository.findByIdFetchDetail(Long.valueOf(request.getTransactionId()))
                                                      .orElseThrow(new ConsumeReportApiException("TransactionId",
                                                                                                 ErrorCodeEnum.BAD_REQUEST_ERROR));
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setCustomerInfo(Arrays.asList(customerInfoMapper.mapper(byTransactionId.getCustomerInfo())));
        transactionResponse.setFx(Arrays.asList(createFx(byTransactionId.getAmount(), byTransactionId.getCurrency())));
        transactionResponse.setAcquirerTransactions(Arrays.asList(acquirerMapper.map(byTransactionId.getAcquirer())));
        transactionResponse.setMerchant(Arrays.asList(merchantMapper.map(byTransactionId.getMerchant())));
        transactionResponse.setMerchantTransactions(Arrays.asList(transactionMapper.map(byTransactionId)));
        return transactionResponse;
    }

    private FX createFx(BigDecimal amount, Currency currency) {
        FX fx = new FX();
        fx.setMerchant(new FXMerchant(amount, currency));
        return fx;
    }

    @Override
    public TransactionListResponse getList(TransactionListRequest request) {
        List<TransactionEntity> all = repository.findAll();
        return null;
    }

    @Override
    public TransactionReportResponse getReport(TransactionReportRequest request) {

        List<TransactionEntity> transactions = repository.findAll(prepareReport(request));
        Map<String, ResponseDto> mapByCurrency = new HashMap<>();
        transactions.forEach(t -> {
            ResponseDto response = mapByCurrency.get(t.getCurrency().toString());
            if (response == null) {
                response = new ResponseDto();
            }
            response.setTotal(response.getTotal().add(t.getAmount()));
            response.setCount(response.getCount() + 1);
            response.setCurrency(t.getCurrency());
            mapByCurrency.put(t.getCurrency().toString(), response);
        });

        TransactionReportResponse reportResponse = new TransactionReportResponse();
        for (Map.Entry<String, ResponseDto> mbc : mapByCurrency.entrySet()) {
            reportResponse.getResponse().add(mbc.getValue());
        }
        reportResponse.setStatus(Status.APPROVED);
        return reportResponse;
    }

    private Specification<TransactionEntity> prepareReport(TransactionReportRequest request) {
        Specification<TransactionEntity> query = Specification.where(null);

        if (request.getFromDate() != null && request.getToDate() != null) {
            query = query.and(TransactionSpecification.fromTo(request.getFromDate(), request.getToDate()));
        }
        if (request.getMerchant() != null) {
            query = query.and(TransactionSpecification.merchant(request.getMerchant()));
        }
        if (request.getAcquirer() != null) {
            query = query.and(TransactionSpecification.acquirer(request.getAcquirer()));
        }
        return query;
    }


}

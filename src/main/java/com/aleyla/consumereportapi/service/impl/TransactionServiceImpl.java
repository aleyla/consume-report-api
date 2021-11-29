package com.aleyla.consumereportapi.service.impl;

import com.aleyla.consumereportapi.model.dto.FX;
import com.aleyla.consumereportapi.model.dto.FXMerchant;
import com.aleyla.consumereportapi.model.dto.ResponseDto;
import com.aleyla.consumereportapi.model.entity.TransactionEntity;
import com.aleyla.consumereportapi.enums.Currency;
import com.aleyla.consumereportapi.enums.ExceptionCode;
import com.aleyla.consumereportapi.enums.Status;
import com.aleyla.consumereportapi.exception.ConsumeReportApiException;
import com.aleyla.consumereportapi.model.mapper.AcquirerMapper;
import com.aleyla.consumereportapi.model.mapper.CustomerInfoMapper;
import com.aleyla.consumereportapi.model.mapper.MerchantMapper;
import com.aleyla.consumereportapi.model.mapper.TransactionMapper;
import com.aleyla.consumereportapi.repository.transaction.TransactionRepository;
import com.aleyla.consumereportapi.repository.transaction.TransactionSpecification;
import com.aleyla.consumereportapi.model.request.ClientInfoRequest;
import com.aleyla.consumereportapi.model.request.TransactionListRequest;
import com.aleyla.consumereportapi.model.request.TransactionReportRequest;
import com.aleyla.consumereportapi.model.request.TransactionRequest;
import com.aleyla.consumereportapi.model.response.ClientInfoResponse;
import com.aleyla.consumereportapi.model.response.TransactionListResponse;
import com.aleyla.consumereportapi.model.response.TransactionReportResponse;
import com.aleyla.consumereportapi.model.response.TransactionResponse;
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
                                                      .orElseThrow(new ConsumeReportApiException("TransactionId", ExceptionCode.BAD_REQUEST_ERROR));
        return customerInfoMapper.map(byTransactionId.getCustomerInfo());
    }

    @Override
    public TransactionResponse getTransaction(TransactionRequest request) {
        TransactionEntity byTransactionId = repository.findByIdFetchDetail(Long.valueOf(request.getTransactionId()))
                                                      .orElseThrow(new ConsumeReportApiException("TransactionId",
                                                                                                 ExceptionCode.BAD_REQUEST_ERROR));
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setCustomerInfo(Arrays.asList(customerInfoMapper.mapper(byTransactionId.getCustomerInfo())));
        transactionResponse.setFx(Arrays.asList(createFx(byTransactionId.getAmount(), byTransactionId.getCurrency())));
        transactionResponse.setAcquirerTransactions(Arrays.asList(acquirerMapper.map(byTransactionId.getAcquirer())));
        transactionResponse.setMerchant(Arrays.asList(merchantMapper.map(byTransactionId.getMerchant())));
        transactionResponse.setTransactions(Arrays.asList(transactionMapper.map(byTransactionId)));
        return transactionResponse;
    }

    private FX createFx(BigDecimal amount, Currency currency) {
        FX fx = new FX();
        fx.setMerchant(new FXMerchant(amount, currency));
        return fx;
    }

    @Override
    public TransactionListResponse getList(TransactionListRequest request) {
        return null;
    }

    @Override
    public List<TransactionEntity> getAll() {
        return repository.findAll();
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
        if (request.getMerchantId() != null) {
            query = query.and(TransactionSpecification.merchant(request.getMerchantId()));
        }
        if (request.getAcquirerId() != null) {
            query = query.and(TransactionSpecification.acquirer(request.getAcquirerId()));
        }
        return query;
    }


}

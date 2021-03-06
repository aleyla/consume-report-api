package com.aleyla.consumereportapi.client;

import com.aleyla.consumereportapi.configuration.RestTemplateConfig;
import com.aleyla.consumereportapi.model.request.*;
import com.aleyla.consumereportapi.model.response.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReportingApiClient {

    private final ReportingApiClientConfig config;

    private final RestTemplateConfig restTemplateConfig;

    public Optional<ReportingApiLoginResponse> login(LoginRequest request) {
        log.info("ReportingApiClient login start");
        try {
            ObjectMapper objectMapper = restTemplateConfig.objectMapper();
            String requestBody = objectMapper.writeValueAsString(request);

            HttpHeaders headers = getHttpHeaders();
            HttpEntity<String> postRequest = new HttpEntity<>(requestBody, headers);
            ResponseEntity<Object> objectResponse = postRequest(getPath(config.getLogin()), postRequest);
            log.info("ReportingApiClient login ok");
            return Optional.of(objectMapper.convertValue(objectResponse.getBody(), ReportingApiLoginResponse.class));
        } catch (Exception e) {
            log.error("login ", e);
        }
        return Optional.empty();
    }

    public Optional<TransactionReportResponse> getReport(TransactionReportRequest request, String token) {
        log.info("ReportingApiClient report start");
        try {
            ObjectMapper objectMapper = restTemplateConfig.objectMapper();
            String requestBody = objectMapper.writeValueAsString(request);

            HttpHeaders headers = getHttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, token);

            HttpEntity<String> postRequest = new HttpEntity<>(requestBody, headers);
            ResponseEntity<Object> objectResponse = postRequest(getPath(config.getReport()), postRequest);
            log.info("ReportingApiClient report ok");
            return Optional.of(objectMapper.convertValue(objectResponse.getBody(), TransactionReportResponse.class));
        } catch (Exception e) {
            log.error("report ", e);
        }
        return Optional.empty();
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.valueOf("application/json;charset=UTF-8"));
        return headers;
    }

    public Optional<TransactionListResponse> getList(TransactionListRequest request, String token) {
        log.info("ReportingApiClient list start");
        try {
            ObjectMapper objectMapper = restTemplateConfig.objectMapper();
            String requestBody = objectMapper.writeValueAsString(request);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, token);
            headers.setContentType(org.springframework.http.MediaType.valueOf("application/json;charset=UTF-8"));
            HttpEntity<String> postRequest = new HttpEntity<>(requestBody, headers);
            ResponseEntity<Object> objectResponse = postRequest(getPath(config.getList()), postRequest);
            log.info("ReportingApiClient list ok");
            return Optional.of(objectMapper.convertValue(objectResponse.getBody(), TransactionListResponse.class));
        } catch (Exception e) {
            log.error("list ", e);
        }
        return Optional.empty();
    }

    public Optional<TransactionResponse> getTransaction(TransactionRequest request, String token) {
        log.info("ReportingApiClient transaction start");
        try {
            HttpHeaders headers = getHttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, token);
            ObjectMapper objectMapper = restTemplateConfig.objectMapper();
            String requestBody = objectMapper.writeValueAsString(request);
            HttpEntity<String> postRequest = new HttpEntity<>(requestBody, headers);
            ResponseEntity<Object> objectResponse = postRequest(getPath(config.getTransaction()), postRequest);
            log.info("ReportingApiClient transaction ok");
            return Optional.of(objectMapper.convertValue(objectResponse.getBody(), TransactionResponse.class));
        } catch (Exception e) {
            log.error("transaction ", e);
        }
        return Optional.empty();
    }

    public Optional<ClientInfoResponse> getClientInfo(ClientInfoRequest request, String token) {
        log.info("ReportingApiClient client start");
        try {
            HttpHeaders headers = getHttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, token);
            ObjectMapper objectMapper = restTemplateConfig.objectMapper();
            String requestBody = objectMapper.writeValueAsString(request);
            HttpEntity<String> postRequest = new HttpEntity<>(requestBody, headers);
            ResponseEntity<Object> objectResponse = postRequest(getPath(config.getClient()), postRequest);
            log.info("ReportingApiClient client ok");
            return Optional.of(objectMapper.convertValue(objectResponse.getBody(), ClientInfoResponse.class));
        } catch (Exception e) {
            log.error("clientInfo ", e);
        }
        return Optional.empty();
    }

    private ResponseEntity<Object> postRequest(String path, HttpEntity<String> request) {
        log.debug("request started. url:[{}]", path);
        return restTemplateConfig.restTemplate().exchange(path, HttpMethod.POST, request, Object.class);
    }

    private String getPath(String path) {
        return config.getPath().concat(path);
    }

}

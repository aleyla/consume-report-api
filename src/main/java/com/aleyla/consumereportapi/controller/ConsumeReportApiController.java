package com.aleyla.consumereportapi.controller;

import com.aleyla.consumereportapi.request.LoginRequest;
import com.aleyla.consumereportapi.response.ReportingApiLoginResponse;
import com.aleyla.consumereportapi.response.TransactionReportResponse;
import com.aleyla.consumereportapi.service.ConsumeReportApiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/v1/consume-report")
public class ConsumeReportApiController {

    private final ConsumeReportApiService service;

    public ConsumeReportApiController(ConsumeReportApiService service) {
        this.service = service;
    }

    @PostMapping(value = "/login")
    public ReportingApiLoginResponse login(@Valid @RequestBody LoginRequest request) {
        return service.login(request);
    }

    @PostMapping(value = "/report")
    public TransactionReportResponse getReport(@Valid @RequestBody LoginRequest request) {
        return service.getReport(request);
    }


}

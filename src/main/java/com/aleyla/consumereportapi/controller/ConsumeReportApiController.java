package com.aleyla.consumereportapi.controller;

import com.aleyla.consumereportapi.model.request.LoginRequest;
import com.aleyla.consumereportapi.model.response.ReportingApiLoginResponse;
import com.aleyla.consumereportapi.service.ConsumeReportApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/consume-report")
public class ConsumeReportApiController {

    private final ConsumeReportApiService service;

    @PostMapping(value = "/login")
    public ReportingApiLoginResponse login(@Valid @RequestBody LoginRequest request) {
        return service.login(request);
    }

}

package com.aleyla.consumereportapi.controller;

import com.aleyla.consumereportapi.dto.Transaction;
import com.aleyla.consumereportapi.entity.TransactionEntity;
import com.aleyla.consumereportapi.enums.Status;
import com.aleyla.consumereportapi.request.*;
import com.aleyla.consumereportapi.response.*;
import com.aleyla.consumereportapi.security.jwt.TokenCreator;
import com.aleyla.consumereportapi.service.Constants;
import com.aleyla.consumereportapi.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v3")
public class ReportApiController {

    private final TransactionService transactionService;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenCreator tokenCreator;


    @PostMapping(value = "/merchant/user/login")
    public ResponseEntity<ReportingApiLoginResponse> login(@Valid @RequestBody LoginRequest request) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new
                UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = tokenCreator.createToken(authentication, false);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(Constants.AUTHORIZATION_HEADER, Constants.AUTHORIZATION_KEY.concat(token));
        return new ResponseEntity<>(new ReportingApiLoginResponse(token, Status.APPROVED), httpHeaders, HttpStatus.OK);
    }

    @PostMapping(value = "/client")
    public ResponseEntity<ClientInfoResponse> getClientInfo(@Valid @RequestBody ClientInfoRequest request) {
        return ResponseEntity.ok(transactionService.getClient(request));
    }

    @PostMapping(value = "/transaction")
    public ResponseEntity<TransactionResponse> getTransaction(@Valid @RequestBody TransactionRequest request) {
        return ResponseEntity.ok(transactionService.getTransaction(request));
    }

    @PostMapping(value = "/transactions/report")
    public ResponseEntity<TransactionReportResponse> getReport(@Valid @RequestBody TransactionReportRequest request) {
        return ResponseEntity.ok(transactionService.getReport(request));
    }

    @PostMapping(value = "/transaction/list")
    public ResponseEntity<TransactionListResponse> getList(@Valid @RequestBody TransactionListRequest request) {
        return ResponseEntity.ok(transactionService.getList(request));
    }

    @PostMapping(value = "/transactions")
    public ResponseEntity<List<Transaction>> getAll() {
        return ResponseEntity.ok(transactionService.getAll());
    }

}

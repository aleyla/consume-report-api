package com.aleyla.consumereportapi.dto;

import com.aleyla.consumereportapi.enums.Channel;
import com.aleyla.consumereportapi.enums.Operation;
import com.aleyla.consumereportapi.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantTransaction {

    private String referenceNo;

    private Long merchantId;

    private Status status;

    private Channel channel;

    private String customData;

    private String chainId;

    private Long agentInfoId;

    private Operation operation;

    private Long fxTransactionId;

    @JsonProperty("updated_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @JsonProperty("created_at")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    private Long id;

    private Long acquirerTransactionId;

    private String code;

    private String message;

    private String transactionId;

    private Agent agent;

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public Long getAgentInfoId() {
        return agentInfoId;
    }

    public void setAgentInfoId(Long agentInfoId) {
        this.agentInfoId = agentInfoId;
    }

    public Long getFxTransactionId() {
        return fxTransactionId;
    }

    public void setFxTransactionId(Long fxTransactionId) {
        this.fxTransactionId = fxTransactionId;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAcquirerTransactionId() {
        return acquirerTransactionId;
    }

    public void setAcquirerTransactionId(Long acquirerTransactionId) {
        this.acquirerTransactionId = acquirerTransactionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}

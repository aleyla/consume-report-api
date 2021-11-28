package com.aleyla.consumereportapi.dto;

import com.aleyla.consumereportapi.enums.Channel;
import com.aleyla.consumereportapi.enums.Operation;
import com.aleyla.consumereportapi.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
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
}

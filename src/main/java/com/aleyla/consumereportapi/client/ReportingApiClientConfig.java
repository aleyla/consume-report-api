package com.aleyla.consumereportapi.client;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "reporting.api")
public class ReportingApiClientConfig {

    private String path;

    private String login;

    private String report;

    private String list;

    private String transaction;

    private String client;
}

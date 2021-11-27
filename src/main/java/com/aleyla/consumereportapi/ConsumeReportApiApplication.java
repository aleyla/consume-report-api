package com.aleyla.consumereportapi;

import com.aleyla.consumereportapi.client.ReportingApiClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableConfigurationProperties(ReportingApiClientConfig.class)
public class ConsumeReportApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeReportApiApplication.class, args);
    }

}

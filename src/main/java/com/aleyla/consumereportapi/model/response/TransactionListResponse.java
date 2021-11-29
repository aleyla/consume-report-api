package com.aleyla.consumereportapi.model.response;

import com.aleyla.consumereportapi.model.dto.DataDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionListResponse {

    @JsonProperty("per_page")
    private int perPage;

    @JsonProperty("current_page")
    private int currentPage;

    @JsonProperty("next_page_url")
    private String nextPageUrl;

    @JsonProperty("prev_page_url")
    private String prevPageUrl;

    private int from;

    private int to;

    private List<DataDto> data;
}

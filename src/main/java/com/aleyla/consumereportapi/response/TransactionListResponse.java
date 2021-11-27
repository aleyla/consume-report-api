package com.aleyla.consumereportapi.response;

import com.aleyla.consumereportapi.dto.DataDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(String prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public List<DataDto> getData() {
        return data;
    }

    public void setData(List<DataDto> data) {
        this.data = data;
    }
}

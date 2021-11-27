package com.aleyla.consumereportapi.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Operation {
    DIRECT,
    REFUND,
    @JsonProperty("3D")
    TREED,
    @JsonProperty("3DAUTH")
    TREEDAUTH,
    STORED;
}

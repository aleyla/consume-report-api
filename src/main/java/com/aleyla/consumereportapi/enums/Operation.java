package com.aleyla.consumereportapi.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Operation {
    DIRECT,
    REFUND,
    @JsonProperty("3D")
    THREE_D,
    @JsonProperty("3DAUTH")
    THREE_D_AUTH,
    STORED;
}

package com.aleyla.consumereportapi.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Operation {
    DIRECT,
    REFUND,
    @JsonProperty("3D")
    TREE_D,
    @JsonProperty("3DAUTH")
    TREE_D_AUTH,
    STORED;
}

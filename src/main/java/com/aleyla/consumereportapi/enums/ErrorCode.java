package com.aleyla.consumereportapi.enums;

public enum ErrorCode {
    DNH("Do not honor"),
    INVALID_TRANSACTION("Invalid transaction"),
    INVALID_CARD("Invalid Card"),
    NOT_SUFFICIENT("Not sufficient funds"),
    INCORRECT_PIN("Incorrect PIN"),
    CURRENCY_NOT_ALLOWED("Currency not allowed"),
    INVALID_COUNTRY("Invalid country association"),
    TREE_D("3-D Secure Transport Error");

    private String label;

    ErrorCode(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}

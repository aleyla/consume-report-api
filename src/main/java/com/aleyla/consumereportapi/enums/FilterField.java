package com.aleyla.consumereportapi.enums;

public enum FilterField {
    UUID("Transaction UUID"),
    CUSTOMER_EMAIL("Customer Email"),
    REFERENCE_NO("Reference No"),
    CUSTOM_DATA("Custom Data"),
    CARD_PAN("Card PAN");

    private String label;

    FilterField(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}

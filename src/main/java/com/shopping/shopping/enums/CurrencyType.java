package com.shopping.shopping.enums;

public enum CurrencyType {
    TRY("TRY", "Turk Lirasi", "TL"),
    USD("USD" , "Dolar", "$"),
    EUR("EUR", "Euro", "€"),
    GBP("GBP", "Sterlin", "£");

    public String code;

    public String description;

    public String symbol;

    CurrencyType(String code, String description, String symbol) {
        this.code = code;
        this.description = description;
        this.symbol = symbol;
    }
}

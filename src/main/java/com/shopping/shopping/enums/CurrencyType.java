package com.shopping.shopping.enums;

import java.util.Objects;

public enum CurrencyType {
    TRY("TRY", "Turk Lirasi", "TL"),
    USD("USD", "Dolar", "$"),
    EUR("EUR", "Euro", "€"),
    GBP("GBP", "Sterlin", "£");

    private String code;
    private String description;
    private String symbol;

    CurrencyType(String code, String description, String symbol) {
        this.code = code;
        this.description = description;
        this.symbol = symbol;
    }

    public String getCode() { return this.code; }

    public String getDescription() { return description; }

    public String getSymbol() { return symbol; }

    public static CurrencyType findByCode(String code) throws Throwable {
        if (Objects.nonNull(code)) {
            for (CurrencyType type: CurrencyType.values()) {
                if (code.equalsIgnoreCase(type.code)) {
                    return type;
                }
            }
        }
        throw new Throwable("Invalid Currency Type");
    }
}

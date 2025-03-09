package org.dio.enums;

public enum BankAgency {
    BRADESCO("001"),
    ITAU("341"),
    SANTANDER("033"),
    CAIXA("104"),
    NUBANK("260");

    private final String code;

    BankAgency(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static BankAgency fromCode(String code){
        for (BankAgency bankAgency : BankAgency.values()) {
            if (bankAgency.code.equals(code)) return bankAgency;
        }
        return null;
    }
}

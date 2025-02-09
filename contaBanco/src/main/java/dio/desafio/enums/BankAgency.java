package dio.desafio.enums;

public enum BankAgency {
    BANCO_DO_BRASIL("001"),
    CAIXA_ECONOMICA("104"),
    ITAU("341"),
    BRADESCO("237"),
    SANTANDER("033"),
    BANCO_INTER("077"),
    NUBANK("260");

    private final String code;

    BankAgency(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static BankAgency fromcode(String code) {
        for (BankAgency agency : BankAgency.values()) {
            if (agency.getCode().equals(code)) {
                return agency;
            }
        }
        return null;
    }
}

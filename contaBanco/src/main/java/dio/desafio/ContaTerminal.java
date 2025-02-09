package dio.desafio;

import java.util.ArrayList;
import java.util.List;

public class ContaTerminal {

    private static final List<ContaTerminal> accountList = new ArrayList<>();
    private int accountNumber;
    private String agency;
    private String customerName;
    private String password;
    private double accountBalance;

    public static List<ContaTerminal> getAccountList() {
        return accountList;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}

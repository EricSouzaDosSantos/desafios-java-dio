package org.dio.model;

import org.dio.enums.BankAgency;

public class SavingsAccount extends Account{

    public SavingsAccount(Client client, BankAgency agency, int number, double balance) {
        super(client, agency, number, balance);
    }
}

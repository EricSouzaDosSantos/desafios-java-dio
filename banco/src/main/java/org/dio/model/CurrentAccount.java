package org.dio.model;

import org.dio.enums.BankAgency;

public class CurrentAccount extends Account{

    public CurrentAccount(Client client, BankAgency agency, int number, double balance) {
        super(client, agency, number, balance);
    }
}

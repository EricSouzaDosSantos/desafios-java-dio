package org.dio.model;

import org.dio.interfaces.IAccount;
import org.dio.enums.BankAgency;

public class Account implements IAccount {
    private BankAgency agency;
    private int number;
    private double balance;
    private Client client;

    public Account(Client client, BankAgency agency, int number, double balance) {
        this.client = client;
        this.agency = agency;
        this.number = number;
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public BankAgency getAgency() {
        return agency;
    }

    public void setAgency(BankAgency agency) {
        this.agency = agency;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void transfer(double value, IAccount destinationAccount) {
        this.withdraw(value);
        destinationAccount.deposit(value);
    }
    @Override
    public void deposit(double value) {
        this.balance += value;
    }

    @Override
    public boolean withdraw(double value) {
        if (this.balance < value) {
            return false;
        }else {
            this.balance -= value;
            return true;
        }
    }
}

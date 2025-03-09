package org.dio.interfaces;

public interface IAccount {
    void deposit(double value);
    void withdraw(double value);
    double getBalance();
    void transfer(double value, IAccount account);
}

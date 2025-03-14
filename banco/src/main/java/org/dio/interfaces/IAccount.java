package org.dio.interfaces;

public interface IAccount {
    void deposit(double value);
    boolean withdraw(double value);
    void transfer(double value, IAccount account);
}

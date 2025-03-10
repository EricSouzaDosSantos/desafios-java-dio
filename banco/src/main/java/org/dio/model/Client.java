package org.dio.model;

import org.dio.exceptions.InvalidCPFException;
import org.dio.service.ClientService;

import java.security.NoSuchAlgorithmException;

public class Client {
    private String name;
    private String password;
    private String cpf;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}

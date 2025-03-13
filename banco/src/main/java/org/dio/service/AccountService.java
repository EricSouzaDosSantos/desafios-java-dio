package org.dio.service;

import org.dio.enums.BankAgency;
import org.dio.exceptions.InvalidCPFException;
import org.dio.exceptions.InvalidPasswordException;
import org.dio.model.Account;
import org.dio.model.Client;

import java.security.NoSuchAlgorithmException;
import java.util.*;

public class AccountService {

    private final Map<Client, Account> accountList;

    private final ClientService clientService;

    public AccountService(){
        this.accountList = new HashMap<>();
        this.clientService = new ClientService();
    }

    public void createAccount(Scanner scanner) throws InvalidCPFException, InvalidPasswordException, NoSuchAlgorithmException {
        Client client = clientService.registerClient(scanner);
        Random random = new Random();
        int accountNumber = random.nextInt(9999);
        double balance = 100.0;

        System.out.println("Escolha o número da agência bancária:");
        for (BankAgency agency : BankAgency.values()) {
            System.out.println(agency.name() + " - " + agency.getCode());
        }
        String chosenAgency;
        BankAgency selectedAgency;
        do {
            System.out.print("Digite o número da agência desejada: ");
            chosenAgency = scanner.nextLine();
            selectedAgency = BankAgency.fromCode(chosenAgency);

            if (selectedAgency == null) {
                System.out.println("Código inválido. Tente novamente.");
            }
        } while (selectedAgency == null);

        Account account = new Account(client, selectedAgency, accountNumber, balance);

        accountList.put(client, account);
    }

    private void deposit(Scanner scanner, Account account) {
        System.out.println("Digite o valor do depósito:");
        double value = Double.parseDouble(scanner.nextLine());
        account.deposit(value);
        System.out.println("Depósito realizado com sucesso!");
    }

    public void transfer(Scanner scanner, Account account) {
        System.out.println("Digite o CPF do destinatário:");
        String destinationCPF = scanner.nextLine();
        Client client = clientService.getClientByCPF(destinationCPF);

        if (client != null) {
            Account destinationAccount = accountList.get(client);
            System.out.println("Digite o valor da transferência:");
            double value = Double.parseDouble(scanner.nextLine());
            account.transfer(value, destinationAccount);
            System.out.println("Transferência realizada com sucesso! Saldo atual: " + account.getBalance());
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }
}

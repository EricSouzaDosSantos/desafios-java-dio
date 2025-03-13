package org.dio;

import org.dio.exceptions.InvalidCPFException;
import org.dio.exceptions.InvalidPasswordException;
import org.dio.model.Client;
import org.dio.service.AccountService;
import org.dio.service.ClientService;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    private static AccountService accountService = new AccountService();
    private static ClientService clientService = new ClientService();
    private static Scanner scanner = new Scanner(System.in);
    private static Client clientLogged = null;

    public static void main(String[] args) {

    }

    public static void MainMenu() throws InvalidCPFException, InvalidPasswordException, NoSuchAlgorithmException {
        int optionMenu;
        System.out.println("---------------Menu Principal---------------------");
        do {
            System.out.println("Digite o numero da opção que você deseja:");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Logar na Conta");
            System.out.println("3 - Sair");
            optionMenu = scanner.nextInt();

            switch (optionMenu) {
                case 1:
                    accountService.createAccount(scanner);
                    break;
                case 2:
                    clientLogged = clientService.login(scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção indisponivel");
                    break;
            }
        }while (optionMenu != 3);
    }

    public static void AccountMenu(){
        int optionMenu;
        System.out.println("------------------------Menu Do Banco-------------------------");
        do {
            System.out.println("Digite o numero da opção que você deseja:");
            System.out.println("1 - Transferir");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Ver Saldo Atual");
            System.out.println("5 - Sair da Conta");
            optionMenu = scanner.nextInt();

            switch (optionMenu){
                case 1:
                    break;
            }
        }while (optionMenu != 5);
    }

}
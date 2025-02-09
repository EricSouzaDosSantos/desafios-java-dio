package dio.desafio;

import dio.desafio.enums.BankAgency;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ContaTerminalService {
    private static final Scanner scanner = new Scanner(System.in);

    public void mainUserMenu() {
        int option = 0;
        do {
            System.out.println("---------------------------------");
            System.out.println("Digite o que você deseja fazer:");
            System.out.println("1 - Cadastrar uma conta");
            System.out.println("2 - Entrar em uma conta");
            System.out.println("3 - Sair");
            option = scanner.nextInt();
            System.out.println("---------------------------------");
            scanner.nextLine();

            switch (option) {
                case 1:
                    this.createAccount();
                    break;
                case 2:
                    this.loginAccount();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
            }
        }while (option != 3);
    }

    public void createAccount() {
        ContaTerminal contaTerminal = new ContaTerminal();
        Random random = new Random();
        contaTerminal.setAccountNumber(1000 + random.nextInt(9000));
        contaTerminal.setAccountBalance(100);

        contaTerminal.setCustomerName(readScanner("Digite o nome do usuário: "));

        contaTerminal.setPassword(readScanner("Digite a senha do usuário: "));

        System.out.println("Escolha o número da agência bancária:");
        for (BankAgency agencia : BankAgency.values()) {
            System.out.println(agencia.name() + " - " + agencia.getCode());
        }

        String chosenAgency;
        BankAgency selectedAgency;
        do {
            System.out.print("Digite o número da agência desejada: ");
            chosenAgency = scanner.nextLine();
            selectedAgency = BankAgency.fromcode(chosenAgency);

            if (selectedAgency == null) {
                System.out.println("Código inválido. Tente novamente.");
            }
        } while (selectedAgency == null);

        contaTerminal.setAgency(selectedAgency.getCode());

        ContaTerminal.getAccountList().add(contaTerminal);

        System.out.println("\nConta criada com sucesso!");
        System.out.println("Nome: " + contaTerminal.getCustomerName());
        System.out.println("Número da conta: " + contaTerminal.getAccountNumber());
        System.out.println("Agência: " + contaTerminal.getAgency() + " - " + selectedAgency.name());
        System.out.println("Saldo inicial: R$ " + contaTerminal.getAccountBalance());
        System.out.println();

    }

    public ContaTerminal searchUserByNameAndPassword(String userName, String password) {
        return ContaTerminal.getAccountList().stream()
                .filter(contaTerminal -> contaTerminal.getCustomerName().equalsIgnoreCase(userName) && contaTerminal.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public ContaTerminal loginAccount() {
        String userName = readScanner("Digite o nome do usuário");
        String password = readScanner("Digite a senha do usuário");
        ContaTerminal contaTerminal = this.searchUserByNameAndPassword(userName, password);
        if (contaTerminal == null){
            System.out.println("senha ou usário inválidos");
            return null;
        }else {
            System.out.println("Login efetuado com sucesso");
            return contaTerminal;
        }
    }

    public static String readScanner(String mensagem) {
        String entrada;
        do {
            System.out.println(mensagem);
            entrada = scanner.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Erro: este campo não pode estar vazio. Tente novamente.");
            }
        } while (entrada.isEmpty());
        return entrada;
    }

}
package org.dio.service;

import org.dio.exceptions.InvalidCPFException;
import org.dio.exceptions.InvalidPasswordException;
import org.dio.model.Client;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ClientService {

    private static final Set<String> cpfHashes = ConcurrentHashMap.newKeySet();

    private final List<Client> clientList = new ArrayList<>();

    public Client registerClient(Scanner scanner) throws InvalidCPFException, InvalidPasswordException, NoSuchAlgorithmException {
        try {
            Client client = new Client();
            System.out.println("Digite o nome do cliente:");
            client.setName(scanner.nextLine());
            System.out.println("Digite a senha do(a) " + client.getName() + ":");
            client.setPassword(validatePassword(scanner.nextLine()));
            System.out.println("Digite o CPF do(a) " + client.getName() + ":");
            client.setCpf(validateCPF(scanner.nextLine()));
            clientList.add(client);
            return client;
        } catch (InvalidCPFException | InvalidPasswordException | NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void updateClient(Scanner scanner) throws InvalidCPFException, InvalidPasswordException, NoSuchAlgorithmException {
        System.out.println("Digite o CPF do cliente que deseja atualizar:");
        String cpf = scanner.nextLine();
        Client client = getClientByCPF(cpf);
        if (client != null) {
            System.out.println("Digite o novo nome do cliente:");
            client.setName(scanner.nextLine());
            System.out.println("Digite a nova senha do(a) " + client.getName() + ":");
            client.setPassword(validatePassword(scanner.nextLine()));
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public Client getClientByCPF(String cpfHash) {
        for (Client client : clientList) {
            if (client.getCpf().equals(cpfHash)) {
                return client;
            }
        }
        return null;
    }

    private static boolean CPFExists(String cpf) throws NoSuchAlgorithmException {
        return cpfHashes.contains(hashCPF(cpf)); // Check if CPF is already registered
    }

    public static String validateCPF(String cpf) throws InvalidCPFException, NoSuchAlgorithmException {
        cpf = cpf.replaceAll("\\D", ""); // Remove all non-digit characters

        if (CPFExists(cpf)) { // Check if CPF is already registered
            throw new InvalidCPFException("CPF já cadastrado!");
        }

        if (cpf.length() != 11 || !cpf.matches("\\d+")) { // Check if CPF has 11 digits and only digits
            throw new InvalidCPFException("CPF inválido! Certifique-se de inserir 11 dígitos numéricos.");
        }

        cpf = hashCPF(cpf); // Hash the CPF
        cpfHashes.add(cpf);


        return cpf;
    }

    private static String validatePassword(String password) throws InvalidPasswordException, NoSuchAlgorithmException {
        if (password.length() < 8 && !password.matches(".*\\d.*")) { // Check if password has at least 8 characters and at least one digit
            throw new InvalidPasswordException("Senha inválida! Certifique-se de inserir ao menos 8 caracteres e ao menos um dígito.");
        }
        return hashPassword(password);
    }

    private static String hashCPF(String cpf) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256"); // Create an SHA-256 digest
        byte[] hash = digest.digest(cpf.getBytes(StandardCharsets.UTF_8)); // Hash the CPF
        StringBuilder hexString = new StringBuilder();// Convert the byte array to a hexadecimal string

        for (byte b : hash) {
            hexString.append(String.format("%02x", b));// Format each byte as a two-digit hexadecimal number
        }

        return hexString.toString();
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256"); // Create an SHA-256 digest
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8)); // Hash the password
        StringBuilder hexString = new StringBuilder();// Convert the byte array to a hexadecimal string

        for (byte b : hash) {
            hexString.append(String.format("%02x", b));// Format each byte as a two-digit hexadecimal number
        }

        return hexString.toString();
    }

    public Client login(Scanner scanner) throws NoSuchAlgorithmException {
        System.out.println("Digite seu CPF:");
        String cpf = scanner.nextLine();
        cpf = hashCPF(cpf);

        Client client = getClientByCPF(cpf);
        if (client == null) {
            System.out.println("Nehum Usuário encontrado com esse CPF!");
            return null;
        }

        System.out.println("Digite sua senha:");
        String password = scanner.nextLine();
        String hashedPassword = hashPassword(password);

        if (!client.getPassword().equals(hashedPassword)) {
            System.out.println("Senha incorreta!");
            return null;
        }

        System.out.println("Login bem-sucedido! Bem-vindo, " + client.getName());
        return client;
    }
}

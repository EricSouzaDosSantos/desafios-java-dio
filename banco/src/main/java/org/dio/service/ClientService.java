package org.dio.service;

import org.dio.exceptions.InvalidCPFException;
import org.dio.exceptions.InvalidPasswordException;
import org.dio.model.Client;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ClientService {

    private static final Set<String> cpfHashes = ConcurrentHashMap.newKeySet();

    public static void registerClient(Client client) throws NoSuchAlgorithmException {
        String cpfHash = hashCPF(client.getCpf());
        cpfHashes.add(cpfHash); // Add hashed CPF to the set
    }

    public static String validateCPF(String cpf) throws InvalidCPFException, NoSuchAlgorithmException {
        cpf = cpf.replaceAll("\\D", ""); // Remove all non-digit characters

        if (CPFExists(cpf)) { // Check if CPF is already registered
            throw new InvalidCPFException("CPF já cadastrado!");
        }

        if (cpf.length() != 11 || !cpf.matches("\\d+")) { // Check if CPF has 11 digits and only digits
            throw new InvalidCPFException("CPF inválido! Certifique-se de inserir 11 dígitos numéricos.");
        }


        return cpf;
    }

    public static boolean CPFExists(String cpf)  throws NoSuchAlgorithmException{
            return cpfHashes.contains(cpf); // Check if CPF is already registered

    }

    public static String formatCPF(String cpf) {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public static String validatePassword(String password) throws InvalidPasswordException{
        if (password.length() < 8 && !password.matches(".*\\d.*")) { // Check if password has at least 8 characters and at least one digit
            throw new InvalidPasswordException("Senha inválida! Certifique-se de inserir ao menos 8 caracteres e ao menos um dígito.");
        }
        return password;
    }

    private static String hashCPF(String cpf) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256"); // Create a SHA-256 digest
        byte[] hash = digest.digest(cpf.getBytes(StandardCharsets.UTF_8)); // Hash the CPF
        StringBuilder hexString = new StringBuilder();// Convert the byte array to a hexadecimal string

        for (byte b : hash) {
            hexString.append(String.format("%02x", b));// Format each byte as a two-digit hexadecimal number
        }

        return hexString.toString();
    }
}

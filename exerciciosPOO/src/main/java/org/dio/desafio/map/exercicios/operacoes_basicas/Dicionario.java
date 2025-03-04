package org.dio.desafio.map.exercicios.operacoes_basicas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dicionario {
    private Map<String, String> dicionario;

    public Dicionario() {
        this.dicionario = new HashMap<>();
    }

    public void adicionar(String palavra, String significado) {
        this.dicionario.put(palavra, significado);
    }

    public void removerPalavra(String palavra) {

        if (!dicionario.containsKey(palavra)) {
            System.out.println("A palavra não está no dicionário");
            return;
        }

        this.dicionario.remove(palavra);
        System.out.println("Palavra deletada com sucesso");
    }

    public void exibirPalavras() {
        if (dicionario.isEmpty()) {
            System.out.println("O dicionário está vazio");
            return;
        }

        System.out.println("--------------------Lista----------------------");
        for (Map.Entry<String, String> entry : dicionario.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void pesquisarPalavra(String palavra) {
        System.out.println(dicionario.containsKey(palavra) ? palavra+": "+dicionario.get(palavra) : "A palavra não está no dicionário");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dicionario dicionario = new Dicionario();
        int option = 0;
        do {
            System.out.println("Escolha uma das opções");
            System.out.println("1 - Adicionar palavra");
            System.out.println("2 - Remover palavra");
            System.out.println("3 - Pesquisar palavra");
            System.out.println("4 - Exibir palavras");
            System.out.println("5 - Sair");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Digite uma palavra: ");
                    String palavra = scanner.nextLine();
                    System.out.print("Digite o significado: ");
                    String significado = scanner.nextLine();
                    dicionario.adicionar(palavra, significado);
                    break;
                case 2:
                    System.out.print("Digite uma palavra: ");
                    palavra = scanner.nextLine();
                    dicionario.removerPalavra(palavra);
                    break;
                case 3:
                    System.out.print("Digite uma palavra: ");
                    palavra = scanner.nextLine();
                    dicionario.pesquisarPalavra(palavra);
                    break;
                case 4:
                    dicionario.exibirPalavras();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (option != 5);
    }
}

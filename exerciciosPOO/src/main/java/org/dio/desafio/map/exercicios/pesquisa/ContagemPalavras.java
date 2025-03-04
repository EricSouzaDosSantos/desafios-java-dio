package org.dio.desafio.map.exercicios.pesquisa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContagemPalavras {
    private Map<String, Integer> palavras;

    public ContagemPalavras() {
        this.palavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        palavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (palavras.containsKey(palavra)) {
            System.out.println("A palavra não está no Map");
            return;
        } else if (palavras.isEmpty()) {
            System.out.println("O Map está vazio");
            return;
        }

        palavras.remove(palavra);
        System.out.println("Palavra deletada com sucesso");
    }

    public void exibirContagemPalavras() {
        System.out.println("--------------------Lista----------------------");
        for (Map.Entry<String, Integer> entry : palavras.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void encontrarPalavraMaisFrequente(){
        int maiorContagem = 0;
        String palavraMaisFrequente = "";
        for (Map.Entry<String, Integer> entry : palavras.entrySet()) {
            if(entry.getValue() > maiorContagem){
                maiorContagem = entry.getValue();
                palavraMaisFrequente = entry.getKey();
            }
        }
        System.out.println("Palavra mais frequente é: " + palavraMaisFrequente);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContagemPalavras contagemPalavras = new ContagemPalavras();
        int option = 0;
        do {
            System.out.println("Escolha uma das opções");
            System.out.println("1 - Adicionar palavra");
            System.out.println("2 - Remover palavra");
            System.out.println("3 - Exibir palavras");
            System.out.println("4 - Encontrar palavra mais frequente");
            System.out.println("5 - Sair");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Digite uma palavra: ");
                    String palavra = scanner.nextLine();
                    System.out.print("Digite a contagem: ");
                    int contagem = scanner.nextInt();
                    contagemPalavras.adicionarPalavra(palavra, contagem);
                    break;
                case 2:
                    System.out.print("Digite uma palavra: ");
                    palavra = scanner.nextLine();
                    contagemPalavras.removerPalavra(palavra);
                    break;
                case 3:
                    contagemPalavras.exibirContagemPalavras();
                    break;
                case 4:
                    contagemPalavras.encontrarPalavraMaisFrequente();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (option != 5);
    }


}

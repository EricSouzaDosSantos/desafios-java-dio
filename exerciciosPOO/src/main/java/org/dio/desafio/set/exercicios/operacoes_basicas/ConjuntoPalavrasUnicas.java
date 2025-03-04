package org.dio.desafio.set.exercicios.operacoes_basicas;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicas = new HashSet<>();

    public void adicionarPalavra(String palavra){
        palavrasUnicas.add(palavra);
    }

    public void removerPalavra(String palavra){
        palavrasUnicas.remove(palavra);
    }

    public String verificarPalavra(String palavra){
        return palavrasUnicas.contains(palavra) ? "A palavra está no conjunto" : "A palavra não está no conjunto";
    }

    public void exibirPalavrasUnicas(){
        System.out.println("--------------------Lista----------------------");
        for (String palavra : palavrasUnicas) {
            System.out.println(palavra);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();
        int option = 0;
        do {
            System.out.println("Escolha uma das opções");
            System.out.println("1 - Adicionar palavra");
            System.out.println("2 - Remover palavra");
            System.out.println("3 - Verificar palavra");
            System.out.println("4 - Exibir palavras");
            System.out.println("5 - Sair");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Digite uma palavra: ");
                    String palavra = scanner.nextLine();
                    conjuntoPalavrasUnicas.adicionarPalavra(palavra);
                    break;
                case 2:
                    System.out.print("Digite uma palavra: ");
                    palavra = scanner.nextLine();
                    conjuntoPalavrasUnicas.removerPalavra(palavra);
                    break;
                case 3:
                    System.out.print("Digite uma palavra: ");
                    palavra = scanner.nextLine();
                    System.out.println(conjuntoPalavrasUnicas.verificarPalavra(palavra));
                    break;
                case 4:
                    conjuntoPalavrasUnicas.exibirPalavrasUnicas();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (option != 5);
    }
}

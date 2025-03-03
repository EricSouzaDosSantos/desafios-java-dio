package org.dio.desafio.list.exercicios.soma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SomaNumeros {
    private List<Integer> numeros = new ArrayList<>();

    public void adicionarNumero(int numero){
        numeros.add(numero);
    }

    public void calcularSoma(){
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        System.out.println("A soma dos números é: " + soma);
    }

    public void encontrarMaiorNumero(){
        int maior = 0;
        for (int numero : numeros) {
            if (numero > maior) {
                maior = numero;
            }
        }
        System.out.println("O maior número é: " + maior);
    }

    public void encontrarMenorNumero(){
        int menor = Integer.MAX_VALUE;
        for (int numero : numeros) {
            if (numero < menor) {
                menor = numero;
            }
        }
        System.out.println("O menor número é: " + menor);
    }

    public void exibirNumeros(){
        System.out.println("--------------------Lista----------------------");
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SomaNumeros somaNumeros = new SomaNumeros();
        int option = 0;
        do {
            System.out.println("Escolha uma das opções");
            System.out.println("1 - Adicionar número");
            System.out.println("2 - Calcular soma");
            System.out.println("3 - Encontrar maior número");
            System.out.println("4 - Encontrar menor número");
            System.out.println("5 - Exibir números");
            System.out.println("6 - Sair");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.println("Digite um numero");
                    somaNumeros.adicionarNumero(scanner.nextInt());
                }
                case 2 -> somaNumeros.calcularSoma();
                case 3 -> somaNumeros.encontrarMaiorNumero();
                case 4 -> somaNumeros.encontrarMenorNumero();
                case 5 -> somaNumeros.exibirNumeros();
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (option != 6);
    }
}

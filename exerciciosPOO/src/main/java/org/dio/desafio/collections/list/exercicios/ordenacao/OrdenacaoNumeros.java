package org.dio.desafio.collections.list.exercicios.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrdenacaoNumeros {
    private List<Integer> numeros = new ArrayList<>();

    public void adicionarNumero(int numero) {
        numeros.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> listaAscendente = new ArrayList<>(this.numeros);
        if (numeros.isEmpty()) {
            System.out.println("Lista de números vazia");
            throw new RuntimeException("Lista de números vazia");
        } else {
            Collections.sort(listaAscendente);
            return listaAscendente;
        }
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> listaDescendente = new ArrayList<>(this.numeros);
        if (numeros.isEmpty()) {
            System.out.println("Lista de números vazia");
            throw new RuntimeException("Lista de números vazia");
        } else {
            listaDescendente.sort(Collections.reverseOrder());
            return listaDescendente;
        }
    }

    public void exibirNumeros() {
        System.out.println("--------------------Lista----------------------");
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();
        int option = 0;
        do {
            System.out.println("Escolha uma das opções");
            System.out.println("1 - Adicionar número");
            System.out.println("2 - Ordenar números de forma ascendente");
            System.out.println("3 - Ordenar números de forma descendente");
            System.out.println("4 - Exibir números");
            System.out.println("5 - Sair");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Digite um número: ");
                    int numero = scanner.nextInt();
                    ordenacaoNumeros.adicionarNumero(numero);
                    break;
                case 2:
                    try {
                        List<Integer> listaAscendente = ordenacaoNumeros.ordenarAscendente();
                        System.out.println("Lista de números ordenada de forma ascendente: " + listaAscendente);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        List<Integer> listaDescendente = ordenacaoNumeros.ordenarDescendente();
                        System.out.println("Lista de números ordenada de forma descendente: " + listaDescendente);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    ordenacaoNumeros.exibirNumeros();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (option != 5);
    }

}

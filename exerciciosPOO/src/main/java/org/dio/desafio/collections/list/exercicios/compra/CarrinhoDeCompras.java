package org.dio.desafio.collections.list.exercicios.compra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarrinhoDeCompras {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Item> carrinhoDeCompras = new ArrayList<>();
    public static void main(String[] args) {

        int opcao = 0;
        do {
            System.out.println("=== Carrinho de Compras ===");
            System.out.println("1 - Adicionar item");
            System.out.println("2 - Exibir itens");
            System.out.println("3 - Remover item");
            System.out.println("4 - Calcular valor total");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Nome do item: ");
                    String nome = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    adicionarItem(nome, quantidade, preco);
                    break;
                case 2:
                    exibirItens();
                    break;
                case 3:
                    System.out.print("Nome do item: ");
                    nome = scanner.nextLine();
                    removerItem(nome);
                    break;
                case 4:
                    calcularValorTotal();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

    }
    public static void adicionarItem(String nome, int quantidade, double preco) {
        if (nome.isEmpty() || quantidade <= 0 || preco <= 0) {
            System.out.println("Erro: Dados inválidos!");
            return;
        }
        Item item = new Item(nome, quantidade, preco);
        carrinhoDeCompras.add(item);
    }
    public static void exibirItens() {
        if (carrinhoDeCompras.isEmpty()) {
            System.out.println("Carrinho vazio!");
            return;
        }
        System.out.println("=== Itens no Carrinho ===");
        for (Item item : carrinhoDeCompras) {
            System.out.println("Nome: " + item.getName());
            System.out.println("Quantidade: " + item.getQuantidade());
            System.out.println("Preço: " + item.getPreco());
            System.out.println();
        }
    }

    public static void removerItem(String nome) {
        if (nome.isEmpty()) {
            System.out.println("Erro: Nome inválido!");
            return;
        }
        for (Item item : carrinhoDeCompras) {
            if (item.getName().equals(nome)) {
                carrinhoDeCompras.remove(item);
                System.out.println("Item removido com sucesso!");
                return;
            }
        }
        System.out.println("Erro: Item não encontrado!");
    }

    public static void calcularValorTotal(){
        double total = 0;
        for (Item item : carrinhoDeCompras) {
            total += item.getQuantidade() * item.getPreco();
        }
        System.out.println("Valor total: R$" + total);
    }
}

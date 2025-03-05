package org.dio.desafio.collections.list.exercicios.compra;

public class Item {
    private String name;
    private int quantidade;
    private double preco;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantidade = quantity;
        this.preco = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

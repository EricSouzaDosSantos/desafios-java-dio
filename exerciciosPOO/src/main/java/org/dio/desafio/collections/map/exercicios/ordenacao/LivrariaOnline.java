package org.dio.desafio.collections.map.exercicios.ordenacao;

import java.util.*;

public class LivrariaOnline {

    private Map<String, Livro> livros;

    public LivrariaOnline() {
        this.livros = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        Livro livro = new Livro(titulo, autor, preco);
        this.livros.put(link, livro);
    }

    public void removerLivros(String titulo) {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
            return;
        }
        this.livros.entrySet().removeIf(entry -> entry.getValue().getTitulo().equalsIgnoreCase(titulo));
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
            return null;
        }
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livros.entrySet());
        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());
        Map<String, Livro> livrosOrdenadosPorPreco = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
            livrosOrdenadosPorPreco.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorPreco;

    }

    public void pesquisarLivrosPorAutor(String autor) {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
            return;
        }
        for (Map.Entry<String, Livro> entry : livros.entrySet()) {
            if (entry.getValue().getAutor().equalsIgnoreCase(autor)) {
                System.out.println(entry.getKey() + " - " + entry.getValue().getTitulo());
            }
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
            return null;
        }
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorAutor = new ArrayList<>(livros.entrySet());
        Collections.sort(livrosParaOrdenarPorAutor, new ComparatorPorAutor());
        Map<String, Livro> livrosOrdenadosPorAutor = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorAutor) {
            livrosOrdenadosPorAutor.put(entry.getKey(), entry.getValue());
        }

        return livrosOrdenadosPorAutor;
    }

    public void obterLivroMaisCaro() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
            return;
        }
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livros.entrySet());
        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());
        Map.Entry<String, Livro> livroMaisCaro = livrosParaOrdenarPorPreco.get(livrosParaOrdenarPorPreco.size() - 1);
        System.out.println("Livro mais caro: " + livroMaisCaro.getKey() + " - " + livroMaisCaro.getValue().getTitulo());
    }

    public void exibirLivroMaisBarato() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
            return;
        }
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livros.entrySet());
        Collections.sort(livrosParaOrdenarPorPreco, new ComparatorPorPreco());
        Map.Entry<String, Livro> livroMaisBarato = livrosParaOrdenarPorPreco.get(0);
        System.out.println("Livro mais barato: " + livroMaisBarato.getKey() + " - " + livroMaisBarato.getValue().getTitulo());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        int option = 0;
        do{
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Remover livros por título");
            System.out.println("3 - Exibir livros ordenados por preço");
            System.out.println("4 - Pesquisar livros por autor");
            System.out.println("5 - Exibir livros ordenados por autor");
            System.out.println("6 - Obter livro mais caro");
            System.out.println("7 - Exibir livro mais barato");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Link: ");
                    String link = scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();
                    livrariaOnline.adicionarLivro(link, titulo, autor, preco);
                    break;
                case 2:
                    System.out.print("Título: ");
                    String tituloParaRemover = scanner.nextLine();
                    livrariaOnline.removerLivros(tituloParaRemover);
                    break;
                case 3:
                    Map<String, Livro> livrosOrdenadosPorPreco = livrariaOnline.exibirLivrosOrdenadosPorPreco();
                    if (livrosOrdenadosPorPreco != null) {
                        for (Map.Entry<String, Livro> entry : livrosOrdenadosPorPreco.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue().getTitulo() + " - " + entry.getValue().getPreco());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Autor: ");
                    String autorParaPesquisar = scanner.nextLine();
                    livrariaOnline.pesquisarLivrosPorAutor(autorParaPesquisar);
                    break;
                case 5:
                    Map<String, Livro> livrosOrdenadosPorAutor = livrariaOnline.exibirLivrosOrdenadosPorAutor();
                    if (livrosOrdenadosPorAutor != null) {
                        for (Map.Entry<String, Livro> entry : livrosOrdenadosPorAutor.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue().getTitulo() + " - " + entry.getValue().getAutor());
                        }
                    }
                    break;

                case 6:
                    livrariaOnline.obterLivroMaisCaro();
                    break;
                case 7:
                    livrariaOnline.exibirLivroMaisBarato();
                    break;
                case 8:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }while (option != 8) ;
    }
}

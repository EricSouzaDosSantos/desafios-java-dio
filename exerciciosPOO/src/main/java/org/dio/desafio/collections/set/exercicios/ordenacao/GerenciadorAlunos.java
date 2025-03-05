package org.dio.desafio.collections.set.exercicios.ordenacao;

import java.util.*;

public class GerenciadorAlunos {
    private Set<Aluno> alunos = new HashSet<>();

    public void adicionarAluno(String nome, double media, long matricula) {
        Aluno aluno = new Aluno(nome, media, matricula);
        alunos.add(aluno);
    }

    public void removerAluno(long matricula) {
        if (alunos.isEmpty()) {
            System.out.println("Você não possui nada na sua lista de alunos.");
            return;
        }

        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == matricula) {
                alunos.remove(aluno);
                break;
            }
        }
    }

    public Set<Aluno> exibirAlunoPorNome(){
        Set<Aluno> alunosEmOrdemAlfabetica = new TreeSet<>(alunos);
        return alunosEmOrdemAlfabetica;
    }

    public Set<Aluno> exibirAlunoPorMedia(){
        Set<Aluno> alunosPorMedia = new TreeSet<>(new ComparatorPorMedia());
        alunosPorMedia.addAll(alunos);
        return alunosPorMedia;
    }


    public void exibirAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Você não possui nada na sua lista de alunos.");
            return;
        }

        System.out.println("--------------------Lista----------------------");
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();
        int option = 0;
        do {
            System.out.println("Escolha uma das opções");
            System.out.println("1 - Adicionar aluno");
            System.out.println("2 - Remover aluno");
            System.out.println("3 - Exibir alunos por nome");
            System.out.println("4 - Exibir alunos por média");
            System.out.println("5 - Exibir alunos");
            System.out.println("6 - Sair");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Digite o nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a média do aluno: ");
                    double media = scanner.nextDouble();
                    System.out.print("Digite a matrícula do aluno: ");
                    long matricula = scanner.nextLong();
                    gerenciadorAlunos.adicionarAluno(nome, media, matricula);
                    break;
                case 2:
                    System.out.print("Digite a matrícula do aluno: ");
                    matricula = scanner.nextLong();
                    gerenciadorAlunos.removerAluno(matricula);
                    break;
                case 3:
                    Set<Aluno> alunosPorNome = gerenciadorAlunos.exibirAlunoPorNome();
                    for (Aluno aluno : alunosPorNome) {
                        System.out.println(aluno.getNome() + " - " +aluno.getMedia());
                    }
                    break;
                case 4:
                    Set<Aluno> alunosPorMedia = gerenciadorAlunos.exibirAlunoPorMedia();
                    for (Aluno aluno : alunosPorMedia) {
                        System.out.println(aluno.getNome() + " - " +aluno.getMedia());
                    }
                    break;
                case 5:
                    gerenciadorAlunos.exibirAlunos();
                    break;
            }
        } while (option != 6);
    }
}


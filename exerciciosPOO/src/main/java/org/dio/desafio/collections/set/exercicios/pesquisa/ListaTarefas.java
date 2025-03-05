package org.dio.desafio.collections.set.exercicios.pesquisa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefas = new HashSet<>();

    public void adicionarTarefa(String descricao) {
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(descricao);
        tarefas.add(tarefa);
    }

    public void removerTarefa(String descricao) {
        if (tarefas.isEmpty()) {
            System.out.println("Você não possui nada na sua lista de tarefas.");
            return;
        }

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefas.remove(tarefa);
                break;
            }
        }
    }

    public void exibirTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Você não possui nada na sua lista de tarefas.");
            return;
        }

        System.out.println("--------------------Lista----------------------");
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa.getDescricao());
        }
    }

    public void contarTarefas() {
        System.out.println("Total de tarefas: " + tarefas.size());
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        if (tarefas.isEmpty()) {
            System.out.println("Você não possui nada na sua lista de tarefas.");
            return new HashSet<>();
        }

        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.isFinalizada()) {
                tarefasConcluidas.add(tarefa);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        if (tarefas.isEmpty()) {
            System.out.println("Você não possui nada na sua lista de tarefas.");
            return new HashSet<>();
        }

        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa tarefa : tarefas) {
            if (!tarefa.isFinalizada()) {
                tarefasPendentes.add(tarefa);
            }
        }
        return tarefasPendentes;
    }

    public void concluirTarefa(String descricao) {
        if (tarefas.isEmpty()) {
            System.out.println("Você não possui nada na sua lista de tarefas.");
            return;
        }

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefa.setFinalizada(true);
                break;
            }
        }
    }

    public void marcarTarefaComoPendente(String descricao) {
        if (tarefas.isEmpty()) {
            System.out.println("Você não possui nada na sua lista de tarefas.");
            return;
        }

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefa.setFinalizada(false);
                break;
            }
        }
    }

    public void limparListaDeTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Você não possui nada na sua lista de tarefas.");
            return;
        }

        tarefas.clear();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaTarefas listaTarefas = new ListaTarefas();
        int option = 0;

        do {
            System.out.println("Escolha uma das opções");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Remover tarefa");
            System.out.println("3 - Exibir tarefas");
            System.out.println("4 - Contar tarefas");
            System.out.println("5 - Obter tarefas concluídas");
            System.out.println("6 - Obter tarefas pendentes");
            System.out.println("7 - Concluir tarefa");
            System.out.println("8 - Marcar tarefa como pendente");
            System.out.println("9 - Limpar lista de tarefas");
            System.out.println("10 - Sair");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    listaTarefas.adicionarTarefa(descricao);
                    break;
                case 2:
                    System.out.print("Digite a descrição da tarefa: ");
                    descricao = scanner.nextLine();
                    listaTarefas.removerTarefa(descricao);
                    break;
                case 3:
                    listaTarefas.exibirTarefas();
                    break;
                case 4:
                    listaTarefas.contarTarefas();
                    break;
                case 5:
                    Set<Tarefa> tarefasConcluidas = listaTarefas.obterTarefasConcluidas();
                    if (tarefasConcluidas.isEmpty()) {
                        System.out.println("Nenhuma tarefa concluída.");
                    }else {
                        System.out.println("Tarefas concluídas: ");
                        for (Tarefa tarefa : tarefasConcluidas) {
                            System.out.println(tarefa.getDescricao());
                        }
                    }
                    break;
                case 6:
                    Set<Tarefa> tarefasPendentes = listaTarefas.obterTarefasPendentes();
                    if (tarefasPendentes.isEmpty()){
                        System.out.println("Nenhuma tarefa pendente.");
                    }else {
                        System.out.println("Tarefas pendentes: ");
                        for (Tarefa tarefa : tarefasPendentes) {
                            System.out.println(tarefa.getDescricao());
                        }
                    }
                    break;
                case 7:
                    System.out.print("Digite a descrição da tarefa: ");
                    descricao = scanner.nextLine();
                    listaTarefas.concluirTarefa(descricao);
                    break;
                case 8:
                    System.out.print("Digite a descrição da tarefa: ");
                    descricao = scanner.nextLine();
                    listaTarefas.marcarTarefaComoPendente(descricao);
                    break;
                case 9:
                    listaTarefas.limparListaDeTarefas();
                    break;
                case 10:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (option != 10);
    }
}

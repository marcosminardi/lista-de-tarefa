package br.newtonpaiva;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeTarefa {
    static ArrayList<String> tarefas = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }
    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n*** Aplicativo de Lista de Tarefas ***");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Remover tarefa");
            System.out.println("3 - Listar tarefas");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionar();
                    break;
                case 2:
                    remover();
                    break;
                case 3:
                    listar();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Você inseriu uma opção inválida! Escolha uma opção entre 1 e 4.");
            }
        } while (opcao != 4);
    }

    private static void adicionar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a tarefa que deseja adicionar: ");
        String tarefa = scanner.nextLine();
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void remover() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da tarefa que deseja remover: ");
        int indice = scanner.nextInt();
        if (indice >= 0 && indice < tarefas.size()) {
            String tarefaRemovida = tarefas.remove(indice);
            System.out.println("Tarefa removida com sucesso: " + tarefaRemovida);
        } else {
            System.out.println("Índice inválido! Escolha um índice entre 0 e " + (tarefas.size() - 1));
        }
    }

    private static void listar() {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas cadastradas!");
        } else {
            System.out.println("Lista de tarefas:");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + " - " + tarefas.get(i));
            }
        }
    }

}

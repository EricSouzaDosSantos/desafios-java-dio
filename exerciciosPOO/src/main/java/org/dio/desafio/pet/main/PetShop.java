package org.dio.desafio.pet.main;

import org.dio.desafio.pet.model.Pet;
import org.dio.desafio.pet.model.PetMachine;

import java.util.Scanner;

public class PetShop {

    private final static Scanner scanner = new Scanner(System.in);

    private final static PetMachine petMachine = new PetMachine();

    public static void main(String[] args) {
        int option = -1;
        do {
            System.out.println("Escolha uma das opções");
            System.out.println("1 - Dar Banho no pet");
            System.out.println("2 - Adicionar água na máquina");
            System.out.println("3 - Adicionar shampoo na máquina");
            System.out.println("4 - Colocar pet na máquina");
            System.out.println("5 - Verificar se tem pet tomando banho");
            System.out.println("6 - Verificar água da máquina");
            System.out.println("7 - Verificar shampoo da máquina");
            System.out.println("8 - Verificar se a máquina está limpa");
            System.out.println("9 - Limpar a máquina");
            System.out.println("0 - Sair");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> petMachine.takeAShower();
                case 2 -> petMachine.addWater();
                case 3 -> petMachine.addShampoo();
                case 4 -> setPetMachine();
                case 5 -> checkPet();
                case 6 -> checkWater();
                case 7 -> checkShampoo();
                case 8 -> checkClean();
                case 9 -> petMachine.wash();
            }
        } while (option != 0);
    }

    public static void setPetMachine() {
        System.out.println("Informe o nome do pet");
        String name = scanner.nextLine();
        Pet pet = new Pet(name);
        petMachine.setPet(pet);
        System.out.println("Pet " + pet.getName() + " adicionado na máquina");
    }

    public static void checkPet() {
        if (petMachine.hasPet()) {
            System.out.println("Há um pet na máquina.");
        } else {
            System.out.println("Não há pet na máquina.");
        }
    }

    public static void checkWater() {
        System.out.println("Nível de água: " + petMachine.getWater());
    }

    public static void checkShampoo() {
        System.out.println("Nível de shampoo: " + petMachine.getShaampoo());
    }

    public static void checkClean() {
        System.out.println("A máquina está " + (petMachine.isClean() ? "limpa" : "suja"));
    }
}
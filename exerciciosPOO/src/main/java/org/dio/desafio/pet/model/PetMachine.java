package org.dio.desafio.pet.model;

public class PetMachine {

    private boolean clean;
    private int water;
    private int shaampoo;
    private Pet pet;

    public PetMachine() {
        this.clean = true;
        this.water = 30;
        this.shaampoo = 10;
    }

    public void takeAShower() {
        if (this.pet == null) {
            System.out.println("Nenhum pet selecionado");
            return;
        }

        this.water -= 10;
        this.shaampoo -= 2;
        pet.setClean(true);
        System.out.println("O Pet " + pet.getName() + " tomou banho");
    }

    public void addWater(){
        if (this.water == 30){
            System.out.println("O tanque de água está cheio");
            return;
        }

        water += 2;
    }

    public void addShampoo(){
        if (this.shaampoo == 10){
            System.out.println("O tanque de shampoo está cheio");
            return;
        }

        shaampoo += 2;
    }

    public boolean isClean() {
        return clean;
    }

    public int getWater() {
        return water;
    }

    public int getShaampoo() {
        return shaampoo;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void setPet(Pet pet) {
    if (!this.clean) {
            System.out.println("A máquina não está limpa, agurade um pouco");
            return;
        }

        if (hasPet()) {
            System.out.println("Já existe um pet tomando banho");
            return;
        }
        this.pet = pet;
    }

    public void removePet() {
        this.clean = this.pet.isClean();

        this.pet = null;
        System.out.println("O oet já tomou banho, a máquina está " + (this.clean ? "limpa" : "suja"));
    }

    public void wash(){
        this.water -= 01;
        this.shaampoo -= 2;
        this.clean = true;
        System.out.println("A máquina está limpa");
    }
}

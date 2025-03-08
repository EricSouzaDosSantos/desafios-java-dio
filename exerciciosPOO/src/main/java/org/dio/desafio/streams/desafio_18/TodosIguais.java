package org.dio.desafio.streams.desafio_18;

import java.util.Arrays;
import java.util.List;

public class TodosIguais {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 1, 1, 1 ,1, 1, 1, 1, 1, 2, 1, 1, 1);
        boolean isIgual = numeros.stream().allMatch(n -> n.equals(numeros.get(0)));
        System.out.println(isIgual ? "Todos os numeros são iguais" : "Os numeros não são todos iguais");
    }
}

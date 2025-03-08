package org.dio.desafio.streams.desafio_16;

import java.util.Arrays;
import java.util.List;

public class NumerosParesEImpares {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        List<Integer> numerosImpares = numeros.stream().filter(n -> n % 2 != 0).toList();
        List<Integer> numerosPares = numeros.stream().filter(n -> n % 2 ==0).toList();
        System.out.println("Lista original: "+numeros);
        System.out.println("Lista de numeros impares: "+numerosImpares);
        System.out.println("Lista de numeros pares: "+numerosPares);

    }
}

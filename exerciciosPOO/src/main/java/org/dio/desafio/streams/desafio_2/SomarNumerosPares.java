package org.dio.desafio.streams.desafio_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SomarNumerosPares {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        List<Integer> numerosPares = numeros.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("Numeros pares: "+Arrays.asList(numerosPares));
        System.out.println("soma dos numeros pares: " + numerosPares.stream().reduce(0, Integer::sum));
    }
}

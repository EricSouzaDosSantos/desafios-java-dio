package org.dio.desafio.streams.desafio_19;

import java.util.Arrays;
import java.util.List;

public class SomaDosDivisiveis {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        List<Integer> divisiveis = numeros.stream().filter(n -> n % 3 == 0 || n % 5 == 0).toList();
        System.out.println("A soma dos divisiveis é: "+divisiveis.stream().reduce(0, Integer::sum));
    }
}

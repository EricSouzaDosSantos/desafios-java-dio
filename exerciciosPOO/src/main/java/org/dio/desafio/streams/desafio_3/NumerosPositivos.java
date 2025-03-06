package org.dio.desafio.streams.desafio_3;

import java.util.Arrays;
import java.util.List;

public class NumerosPositivos {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        System.out.println("Numeros positivos: "+Arrays.asList(numeros.stream().filter(n -> n > 0).toList()));
        System.out.println("Numeros negativos: "+Arrays.asList(numeros.stream().filter(n -> n < 0).toList()));


    }
}

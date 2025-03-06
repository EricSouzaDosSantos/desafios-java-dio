package org.dio.desafio.streams.desafio_4;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RemoverImpares {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        List<Integer> numerosParesComZero = numeros.stream()
                .filter(n -> n % 2 == 0 || n == 0)
                .toList();

        System.out.println("Lista sem os removidos: "+numeros);
        System.out.println("Lista com os removidos: "+numerosParesComZero);

    }
}

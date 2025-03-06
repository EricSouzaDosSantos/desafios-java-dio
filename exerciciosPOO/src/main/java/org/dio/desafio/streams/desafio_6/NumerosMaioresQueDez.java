package org.dio.desafio.streams.desafio_6;

import java.util.Arrays;
import java.util.List;

public class NumerosMaioresQueDez {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        List<Integer> numerosMaioresQueDez = numeros.stream().filter(n -> n > 10).toList();
        System.out.println( numerosMaioresQueDez.isEmpty() ? "A Lista não possui nenhum numero mairo que dez" : "Lista de numeros maiores que dez: "+Arrays.asList(numerosMaioresQueDez));
    }
}

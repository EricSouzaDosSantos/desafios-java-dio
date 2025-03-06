package org.dio.desafio.streams.desafio_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListaCrescente {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        List<Integer> listaOrdenada = numeros.stream().sorted().toList();
        System.out.println("Lista de números: " + listaOrdenada);

    }
}

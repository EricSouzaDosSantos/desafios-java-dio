package org.dio.desafio.streams.desafio_8;

import java.util.Arrays;
import java.util.List;

public class SomarNumeros {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        System.out.println("Soma dos numeros: "+numeros.stream().reduce(0, Integer::sum));
    }
}

package org.dio.desafio.streams.desafio_15;

import java.util.Arrays;
import java.util.List;

public class NumerosNegativos {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        List<Integer> numerosNegativos = numeros.stream().filter(n -> n <0).toList();
        System.out.println(numerosNegativos.isEmpty() ? "A Lista não Possui numeros negativos" : "Numeros negativos: "+numerosNegativos);
    }
}

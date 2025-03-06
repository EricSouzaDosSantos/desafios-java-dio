package org.dio.desafio.streams.desafio_7;

import java.util.Arrays;
import java.util.List;

public class SegundoMaiorNumero {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        List<Integer> numerosOrdenados = numeros.stream().sorted().toList();
        System.out.println("Segundo maior número: " + numerosOrdenados.get(numerosOrdenados.size() - 2));
    }
}

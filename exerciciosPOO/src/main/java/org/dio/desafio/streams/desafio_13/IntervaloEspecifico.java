package org.dio.desafio.streams.desafio_13;

import java.util.Arrays;
import java.util.List;

public class IntervaloEspecifico {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        List<Integer> numerosNoINtervalo = numeros.stream().filter(n -> n >= 5 && n <= 10).toList();
        System.out.println("Numeros no intervalo de 5 a 10: "+numerosNoINtervalo);
    }
}

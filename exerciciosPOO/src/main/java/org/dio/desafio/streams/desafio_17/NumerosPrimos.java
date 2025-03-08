package org.dio.desafio.streams.desafio_17;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NumerosPrimos {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        Predicate<Integer> isPrimo = n -> {
            if (n == 1) return false;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        };

        System.out.println("Numeros primos: "+numeros.stream().filter(isPrimo).toList());

    }
}

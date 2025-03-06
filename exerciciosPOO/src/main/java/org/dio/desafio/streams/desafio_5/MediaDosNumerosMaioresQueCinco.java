package org.dio.desafio.streams.desafio_5;

import java.util.Arrays;
import java.util.List;

public class MediaDosNumerosMaioresQueCinco {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        List<Integer> numerosMaioresQueCinco = numeros.stream().filter(n -> n > 5).toList();
        double media = numerosMaioresQueCinco.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Numeros: "+Arrays.asList(numeros));
        System.out.println("Numeros maiores que cinco: "+Arrays.asList(numerosMaioresQueCinco));
        System.out.println("Média dos numeros maiores que cinco: "+media);
    }
}

package com.notPerfectBot.TecnicaLoggro.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BloquesService {
    private static final List<Set<Character>> BLOQUES = Arrays.asList(
            Set.of('B','O'), Set.of('X','K'), Set.of('D','Q'), Set.of('C','P'),
            Set.of('N','A'), Set.of('G','T'), Set.of('R','E'), Set.of('T','G'),
            Set.of('Q','D'), Set.of('F','S'), Set.of('H','U'), Set.of('V','I'),
            Set.of('A','T'), Set.of('O','B'), Set.of('E','R'), Set.of('F','S'),
            Set.of('L','Y'), Set.of('P','C'), Set.of('Z','M'), Set.of('J','W')
    );

    private static final Map<Character, List<Integer>> MAPA_BLOQUES = new HashMap<>();

    static {
        for (int i = 0; i < BLOQUES.size(); i++) {
            for (char c : BLOQUES.get(i)) {
                MAPA_BLOQUES.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
            }
        }
    }

    public boolean puedoObtenerPalabra(String palabra) {
        palabra = palabra.toUpperCase();
        Set<Integer> usados = new HashSet<>();

        for (char letra : palabra.toCharArray()) {
            List<Integer> posibles = MAPA_BLOQUES.get(letra);
            if (posibles == null) return false;

            boolean asignado = false;
            for (int bloque : posibles) {
                if (!usados.contains(bloque)) {
                    usados.add(bloque);
                    asignado = true;
                    break;
                }
            }
            if (!asignado) return false;
        }
        return true;
    }
}

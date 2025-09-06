package com.notPerfectBot.TecnicaLoggro.repository;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.*;

@Getter
@Component
public class BloquesRepository {

    private final List<Set<Character>> bloques = Arrays.asList(
            Set.of('B','O'), Set.of('X','K'), Set.of('D','Q'), Set.of('C','P'),
            Set.of('N','A'), Set.of('G','T'), Set.of('R','E'), Set.of('T','G'),
            Set.of('Q','D'), Set.of('F','S'), Set.of('H','U'), Set.of('V','I'),
            Set.of('A','T'), Set.of('O','B'), Set.of('E','R'), Set.of('F','S'),
            Set.of('L','Y'), Set.of('P','C'), Set.of('Z','M'), Set.of('J','W')
    );

    private final Map<Character, List<Integer>> mapaBloques = new HashMap<>();

    public BloquesRepository() {
        for (int i = 0; i < bloques.size(); i++) {
            for (char c : bloques.get(i)) {
                mapaBloques.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
            }
        }
    }
}

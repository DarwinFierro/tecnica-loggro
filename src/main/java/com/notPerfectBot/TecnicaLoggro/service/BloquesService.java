package com.notPerfectBot.TecnicaLoggro.service;

import com.notPerfectBot.TecnicaLoggro.repository.BloquesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BloquesService {

    @Autowired
    private final BloquesRepository bloquesRepository;

    public boolean puedoObtenerPalabra(String palabra) {
        palabra = palabra.toUpperCase();
        return backtrack(palabra.toCharArray(), new HashSet<>(), 0);
    }

    private boolean backtrack(char[] letras, Set<Integer> usados, int idx) {
        if (idx == letras.length) return true;

        char letra = letras[idx];
        List<Integer> posibles = bloquesRepository.getMapaBloques().get(letra);
        if (posibles == null) return false;

        for (int bloque : posibles) {
            if (!usados.contains(bloque)) {
                usados.add(bloque);
                if (backtrack(letras, usados, idx + 1)) {
                    return true;
                }
                usados.remove(bloque);
            }
        }
        return false;
    }
}

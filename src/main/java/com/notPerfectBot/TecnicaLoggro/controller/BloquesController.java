package com.notPerfectBot.TecnicaLoggro.controller;

import com.notPerfectBot.TecnicaLoggro.dto.Palabra;
import com.notPerfectBot.TecnicaLoggro.service.BloquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bloques")
public class BloquesController {

    @Autowired
    private BloquesService service;

    @PostMapping("/")
    public boolean puedoObtenerPalabra(@RequestBody Palabra request) {
        return service.puedoObtenerPalabra(request.getPalabra());
    }
}

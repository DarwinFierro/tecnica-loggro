package com.notPerfectBot.TecnicaLoggro;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TecnicaLoggroApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest(name = "Palabra: {0} → esperado: {1}")
    @CsvSource({
            "A, true",
            "LIBRO, true",
            "BOZO, false",
            "TRAJE, true",
            "COMUN, true",
            "CAMPANA, false",
            "DORITO, true",
            "ARLEQUIN, true"
    })
    void testEndpointPostConCasos(String palabra, boolean esperado) throws Exception {
        mockMvc.perform(post("/api/bloques/")
                        .contentType("application/json")
                        .content("{\"palabra\":\"" + palabra + "\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(Boolean.toString(esperado)));
    }
}

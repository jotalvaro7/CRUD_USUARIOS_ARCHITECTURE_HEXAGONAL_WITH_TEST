package com.personales.crudarquitecturahexagonal.aplicacion.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personales.crudarquitecturahexagonal.dominio.modelo.UsuarioDto;
import com.personales.crudarquitecturahexagonal.dominio.ports.UsuarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ControladorUsuario.class)
public class ControladorUsuarioTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    UsuarioService usuarioService;


    @Test
    public void givenUsuarios_whenGetUsuarios_theReturnJsonArray() throws Exception {
        UsuarioDto julio = new UsuarioDto(1, "Julio", 29);

        List<UsuarioDto> usuarios = Arrays.asList(julio);

        Mockito.when(usuarioService.getUsuarios()).thenReturn(usuarios);


        mvc.perform(get("/api/usuarios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].edad", is(julio.getEdad())));

    }

    @Test
    public void whenPostUsuario_thenCreateUsuario() throws Exception {
        UsuarioDto luisa = new UsuarioDto(1, "Luisa", 26);

        Mockito.when(usuarioService.addUsuario(Mockito.any())).thenReturn(luisa);

        mvc.perform(post("/api/register")
            .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(luisa))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre", is(luisa.getNombre())));

    }

}
package com.personales.crudarquitecturahexagonal.dominio.ports;

import com.personales.crudarquitecturahexagonal.dominio.modelo.UsuarioDto;
import com.personales.crudarquitecturahexagonal.dominio.servicios.UsuarioServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UsuarioServiceTest {


    @TestConfiguration
    static class UsuarioServiceTestConfig{
        @Bean
        public UsuarioService usuarioService(){
            return new UsuarioServiceImpl();
        }
    }

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Before
    public void setUp(){
        UsuarioDto luisa = new UsuarioDto(1, "Luisa", 26);
        UsuarioDto juan = new UsuarioDto(2, "juan", 30);
        UsuarioDto gloria = new UsuarioDto(3, "gloria", 56);
        UsuarioDto julio = new UsuarioDto(4, "Julio", 29);

        List<UsuarioDto> usuarios = Arrays.asList(luisa,juan,gloria);

        Mockito.when(usuarioRepository.getUsuarios()).thenReturn(usuarios);
        Mockito.when(usuarioRepository.addUsuario(julio)).thenReturn(julio);

    }


    @Test
    public void givenThreeProducts_whenGetAllProducts_thenThreeProductsReturned() {
        UsuarioDto luisa = new UsuarioDto(1, "Luisa", 26);
        UsuarioDto juan = new UsuarioDto(2, "juan", 30);
        UsuarioDto gloria = new UsuarioDto(3, "gloria", 56);

        List<UsuarioDto> allUsuarios = usuarioService.getUsuarios();

        assertThat(allUsuarios).hasSize(3).extracting(UsuarioDto::getEdad).contains(luisa.getEdad(), juan.getEdad(), gloria.getEdad());

    }

    @Test
    public void whenAddProduct_thenProductEdadIsMatched(){
        UsuarioDto julio = new UsuarioDto(4, "Julio", 29);
        assertThat(usuarioService.addUsuario(julio)).extracting(UsuarioDto::getNombre).as(julio.getNombre());
    }


}
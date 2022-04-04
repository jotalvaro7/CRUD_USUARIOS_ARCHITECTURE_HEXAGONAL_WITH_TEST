package com.personales.crudarquitecturahexagonal.aplicacion.controlador;

import com.personales.crudarquitecturahexagonal.dominio.modelo.UsuarioDto;
import com.personales.crudarquitecturahexagonal.dominio.ports.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControladorUsuario {


    private UsuarioService usuarioService;

    public ControladorUsuario(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping("/register")
    public UsuarioDto save(@RequestBody UsuarioDto usuarioDto){
        return usuarioService.addUsuario(usuarioDto);
    }

    @GetMapping("/usuarios")
    public List<UsuarioDto> getUsuarios(){
        return usuarioService.getUsuarios();
    }


}

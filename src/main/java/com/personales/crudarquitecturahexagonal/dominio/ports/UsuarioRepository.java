package com.personales.crudarquitecturahexagonal.dominio.ports;

import com.personales.crudarquitecturahexagonal.dominio.modelo.UsuarioDto;

import java.util.List;

public interface UsuarioRepository {

    UsuarioDto addUsuario(UsuarioDto usuarioDto);
    List<UsuarioDto> getUsuarios();

}

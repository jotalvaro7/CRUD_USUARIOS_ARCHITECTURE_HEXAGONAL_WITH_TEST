package com.personales.crudarquitecturahexagonal.dominio.servicios;

import com.personales.crudarquitecturahexagonal.dominio.modelo.UsuarioDto;
import com.personales.crudarquitecturahexagonal.dominio.ports.UsuarioRepository;
import com.personales.crudarquitecturahexagonal.dominio.ports.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

//    spublic UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
//        this.usuarioRepository = usuarioRepository;
//    }

    @Override
    public UsuarioDto addUsuario(UsuarioDto usuarioDto) {
        return usuarioRepository.addUsuario(usuarioDto);

    }

    @Override
    public List<UsuarioDto> getUsuarios() {
        return usuarioRepository.getUsuarios();
    }
}

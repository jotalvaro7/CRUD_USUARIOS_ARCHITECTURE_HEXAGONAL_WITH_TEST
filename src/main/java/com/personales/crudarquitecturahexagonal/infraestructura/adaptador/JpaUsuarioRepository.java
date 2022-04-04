package com.personales.crudarquitecturahexagonal.infraestructura.adaptador;

import com.personales.crudarquitecturahexagonal.dominio.modelo.UsuarioDto;
import com.personales.crudarquitecturahexagonal.dominio.ports.UsuarioRepository;
import com.personales.crudarquitecturahexagonal.infraestructura.entity.Usuario;
import com.personales.crudarquitecturahexagonal.infraestructura.mappers.UsuarioMapper;
import com.personales.crudarquitecturahexagonal.infraestructura.repositorios.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaUsuarioRepository implements UsuarioRepository {


    private RepositorioUsuario repositorioUsuario;

    public JpaUsuarioRepository(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }


    @Override
    public UsuarioDto addUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = UsuarioMapper.INSTANCE.usuarioDtoToUsuario(usuarioDto);
        Usuario usuarioSaved = repositorioUsuario.save(usuario);
        return UsuarioMapper.INSTANCE.usuarioToUsuarioDto(usuarioSaved);

    }


    @Override
    public List<UsuarioDto> getUsuarios() {
        List<Usuario> usuarioList = repositorioUsuario.findAll();
        return UsuarioMapper.INSTANCE.usuarioListToUsuarioDtoList(usuarioList);
    }


}

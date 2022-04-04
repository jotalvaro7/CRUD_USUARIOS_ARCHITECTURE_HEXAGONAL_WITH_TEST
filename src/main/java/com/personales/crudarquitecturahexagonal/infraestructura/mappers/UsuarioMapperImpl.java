package com.personales.crudarquitecturahexagonal.infraestructura.mappers;

import com.personales.crudarquitecturahexagonal.dominio.modelo.UsuarioDto;
import com.personales.crudarquitecturahexagonal.infraestructura.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

//@Generated(
//        value = "org.mapstruct.ap.MappingProcessor",
//        date = "2022-04-03T13:38:24-0500",
//        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
//)
public class UsuarioMapperImpl implements UsuarioMapper {
    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        if(usuario == null){
            return null;
        }
        UsuarioDto.UsuarioDtoBuilder usuarioDto = UsuarioDto.builder();
        usuarioDto.id(usuario.getId());
        usuarioDto.nombre(usuario.getNombre());
        usuarioDto.edad(usuario.getEdad());

        return usuarioDto.build();

    }



    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        if(usuarioDto == null){
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();
        usuario.id(usuarioDto.getId());
        usuario.nombre(usuarioDto.getNombre());
        usuario.edad(usuarioDto.getEdad());

        return usuario.build();
    }

    @Override
    public List<UsuarioDto> usuarioListToUsuarioDtoList(List<Usuario> usuarioList) {
        if(usuarioList == null){
            return null;
        }

        List<UsuarioDto> list = new ArrayList<>(usuarioList.size());
        for (Usuario usuario : usuarioList){
            list.add(usuarioToUsuarioDto(usuario));
        }

        return list;
    }

    @Override
    public List<Usuario> usuarioDtoListToUsuarioList(List<UsuarioDto> usuarioDtoList) {
        return null;
    }
}

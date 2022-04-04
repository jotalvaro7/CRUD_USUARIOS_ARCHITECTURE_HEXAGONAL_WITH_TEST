package com.personales.crudarquitecturahexagonal.infraestructura.mappers;

import com.personales.crudarquitecturahexagonal.dominio.modelo.UsuarioDto;
import com.personales.crudarquitecturahexagonal.infraestructura.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDto usuarioToUsuarioDto(Usuario usuario);

    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);

    List<UsuarioDto> usuarioListToUsuarioDtoList(List<Usuario> usuarioList);

    List<Usuario> usuarioDtoListToUsuarioList(List<UsuarioDto> usuarioDtoList);

}

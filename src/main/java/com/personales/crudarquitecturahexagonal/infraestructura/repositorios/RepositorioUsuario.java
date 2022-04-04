package com.personales.crudarquitecturahexagonal.infraestructura.repositorios;

import com.personales.crudarquitecturahexagonal.infraestructura.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
}

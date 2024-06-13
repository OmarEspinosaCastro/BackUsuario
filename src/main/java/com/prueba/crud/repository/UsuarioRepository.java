package com.prueba.crud.repository;

import com.prueba.crud.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,String> {
    Optional<Usuario> findOneByLogin(String login);

    List<Usuario> findByStatus(char estatus);

    List<Usuario> findByNombre(String nombre);

    List<Usuario> findByFechaalta(String fechaAlta);

    List<Usuario> findByFechabaja(String fechaBaja);

    Usuario findByLogin(String login);

}

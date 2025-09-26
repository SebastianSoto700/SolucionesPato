package com.example.Integrador2.repository;

import com.example.Integrador2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByEstadoTrue();

    Optional<Usuario> findByCorreo(String correo);

}

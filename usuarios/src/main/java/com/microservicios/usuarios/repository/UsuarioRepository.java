package com.microservicios.usuarios.repository;

import com.microservicios.usuarios.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByEmail(String email);
    Optional<UsuarioEntity> findByEmailAndPassword(String email, String password);
}

package com.sistema.registro.tramites.sistemaregistrotramitesbackend.repositorio;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUserName(String userName);

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);
}

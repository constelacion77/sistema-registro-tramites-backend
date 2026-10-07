package com.sistema.registro.tramites.sistemaregistrotramitesbackend.service;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Usuario;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepositorio repositorio;
    public UsuarioService(UsuarioRepositorio repositorio){
        this.repositorio = repositorio;
    }

    public boolean existeUsuarioPorNombre(String userName){
        return repositorio.existsByUserName(userName);
    }

    public boolean existeUsuarioPorEmail(String email){
        return repositorio.existsByEmail(email);
    }

    public Usuario guardarUsuario(Usuario usuario){
        return repositorio.save(usuario);
    }

    public Optional<Usuario> obtenerUsuarioPorNombre(String userName){
        return repositorio.findByUserName(userName);
    }
}

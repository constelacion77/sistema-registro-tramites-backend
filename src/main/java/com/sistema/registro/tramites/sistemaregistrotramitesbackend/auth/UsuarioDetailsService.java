package com.sistema.registro.tramites.sistemaregistrotramitesbackend.auth;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioService.obtenerUsuarioPorNombre(username)
                .map(usuario -> User.withUsername(usuario.getUserName())
                        .password(usuario.getPassword())
                        .roles(usuario.getRol())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
    }
}

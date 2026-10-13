package com.sistema.registro.tramites.sistemaregistrotramitesbackend.auth.dto;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Usuario;

public record AuthResponse(
        String token,
        String userName,
        String email,
        String rol
) {
    public AuthResponse(String token, Usuario usuario) {
        this(token, usuario.getUserName(), usuario.getEmail(), usuario.getRol().name());
    }
}

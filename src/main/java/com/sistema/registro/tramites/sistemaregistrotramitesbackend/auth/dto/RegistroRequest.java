package com.sistema.registro.tramites.sistemaregistrotramitesbackend.auth.dto;
import jakarta.validation.constraints.*;

public record RegistroRequest(
        @NotBlank String userName,
        @NotBlank @Email String email,
        @NotBlank @Size(min = 6) String password
) {}

package com.sistema.registro.tramites.sistemaregistrotramitesbackend.excepciones;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionID = 1L;

    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}

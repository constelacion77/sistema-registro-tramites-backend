package com.sistema.registro.tramites.sistemaregistrotramitesbackend.excepciones;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> manejarIntegridad(
            DataIntegrityViolationException ex){
        String titulo = "Ocurrió un error al guardar el usuario.";
        String mensaje = "Ha ocurrido un error";
        Throwable causa = ex.getRootCause();

        if(causa != null){
            String texto = causa.getMessage();
            if(texto.contains("email_UNIQUE")){
                mensaje = "El correo electrónico ya se encuentra registrado.";
            } else if (texto.contains("curp_UNIQUE")) {
                mensaje = "La CURP ya se encuentra registrada";
            }
        }

        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                titulo,
                mensaje,
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }
}

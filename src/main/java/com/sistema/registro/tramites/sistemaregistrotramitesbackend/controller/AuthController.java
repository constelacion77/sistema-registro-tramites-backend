package com.sistema.registro.tramites.sistemaregistrotramitesbackend.controller;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.auth.AuthService;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.auth.dto.LoginRequest;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.auth.dto.RegistroRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@Valid @RequestBody RegistroRequest request){
        return service.registrarNuevoUsuario(request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request){
        return service.loggearUsuario(request);
    }
}

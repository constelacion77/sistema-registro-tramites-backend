package com.sistema.registro.tramites.sistemaregistrotramitesbackend.auth;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.auth.dto.AuthResponse;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.auth.dto.LoginRequest;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.auth.dto.RegistroRequest;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Usuario;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public AuthService(UsuarioService usuarioService,
                          PasswordEncoder passwordEncoder,
                          JwtService jwtService){
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public ResponseEntity<?> registrarNuevoUsuario(RegistroRequest request){
        if(usuarioService.existeUsuarioPorNombre(request.userName())){
            return ResponseEntity.badRequest().body(Map.of("error", "El nombre de usuario ya está registrado."));
        }
        if(usuarioService.existeUsuarioPorEmail(request.email())){
            return ResponseEntity.badRequest().body(Map.of("error", "El correo ya se encuentra registrado."));
        }
        Usuario usuario = usuarioService.guardarUsuario(new Usuario(request, passwordEncoder.encode(request.password())));
        String token = jwtService.generarToken(usuario);

        return ResponseEntity.ok(new AuthResponse(token, usuario));
    }

    public ResponseEntity<?> loggearUsuario(LoginRequest request){
        return usuarioService.obtenerUsuarioPorNombre(request.userName())
                .map(usuario ->{
                    if(!passwordEncoder.matches(request.password(), usuario.getPassword())){
                        return ResponseEntity.status(401)
                                .body(Map.of("error", "Credenciales invalidas."));
                    }
                    String token = jwtService.generarToken(usuario);
                    return ResponseEntity.ok(new AuthResponse(token, usuario));
                })
                .orElse(ResponseEntity.status(401)
                        .body(Map.of("error", "Credenciales invalidas")));
    }
}

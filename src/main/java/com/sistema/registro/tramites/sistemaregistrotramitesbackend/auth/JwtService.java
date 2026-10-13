package com.sistema.registro.tramites.sistemaregistrotramitesbackend.auth;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secreto}")
    private String secreto;

    @Value("${jwt.expiracion}")
    private long expiracion;

    private SecretKey obtenerClave() {
        return Keys.hmacShaKeyFor(secreto.getBytes(StandardCharsets.UTF_8));
    }

    public String generarToken(Usuario usuario) {
        Instant ahora = Instant.now();
        return Jwts.builder()
                .subject(usuario.getUserName())
                .claim("rol", usuario.getRol().name())
                .issuedAt(Date.from(ahora))
                .expiration(Date.from(ahora.plusMillis(expiracion)))
                .signWith(obtenerClave())
                .compact();
    }

    public String extraerUserName(String token) {
        return Jwts.parser()
                .verifyWith(obtenerClave())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean esValido(String token, UserDetails userDetails) {
        String username = extraerUserName(token);
        return username.equals(userDetails.getUsername()) && !estaExpirado(token);
    }

    private boolean estaExpirado(String token) {
        Date expiracion = Jwts.parser()
                .verifyWith(obtenerClave())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration();
        return expiracion.before(new Date());
    }
}

package com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.auth.dto.RegistroRequest;
import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true, nullable = false)
    private String userName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", unique = true, nullable = false)
    private String password;

    @Column(name = "rol", nullable = false)
    private String rol = "USER";

    public Usuario() {
    }

    public Usuario(RegistroRequest request, String password) {
        this.userName = request.userName();
        this.email = request.email();
        this.password = password;
//        this.idRol = request.getR;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

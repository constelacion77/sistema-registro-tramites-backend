package com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "beneficiarios")
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 150)
    private String apellidos;

    @Column(name="curp", length = 18, nullable = false)
    private String curp;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_modifico")
    private LocalDateTime fechaModifico;

    @Column(name = "fecha_elimino")
    private LocalDateTime fechaElimino;

    public Beneficiario(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getFechaModifico() {
        return fechaModifico;
    }

    public void setFechaModifico(LocalDateTime fechaModifico) {
        this.fechaModifico = fechaModifico;
    }

    public LocalDateTime getFechaElimino() {
        return fechaElimino;
    }

    public void setFechaElimino(LocalDateTime fechaElimino) {
        this.fechaElimino = fechaElimino;
    }

    @Override
    public String toString() {
        return "Beneficiario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", curp='" + curp + '\'' +
                '}';
    }

    public String getNombreCompleto(){
        return this.nombre + " " + this.apellidos;
    }
}

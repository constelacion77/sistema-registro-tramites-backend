package com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "documentos")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 150, nullable = false)
    private String nombre;

    @Column(name = "costo", nullable = false)
    private BigDecimal costo;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_modifico")
    private LocalDateTime fechaModifico;

    @Column(name = "fecha_elimino")
    private LocalDateTime fechaElimino;

    @Column(name = "activo")
    private boolean activo;

    public Documento(){}

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

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", costo=" + costo +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

package com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.TramiteRequest;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="Tramites")
public class Tramite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_documento", nullable = false)
    private Documento idDocumento;

    @ManyToOne
    @JoinColumn(name="id_beneficiario", nullable = false)
    private Beneficiario idBeneficiario;

    @Column(name="folio")
    private String folio;

    @Column(name="fecha_generacion", nullable = false)
    private LocalDateTime fechaGeneracion;

    @Column(name="fecha_modifico")
    private LocalDateTime fechaModifico;

    @Column(name="fecha_elimino")
    private LocalDateTime fechaElimino;

    @Column(name="honorarios")
    private BigDecimal honorarios;

    public Tramite() {
    }

    public Tramite(TramiteRequest tramiteRequest) {
        this.id = tramiteRequest.getId();
        this.folio = tramiteRequest.getFolio();
        this.fechaGeneracion = tramiteRequest.getFechaGeneracion();
        this.fechaModifico = tramiteRequest.getFechaModifico();
        this.fechaElimino = tramiteRequest.getFechaElimino();
        this.honorarios = tramiteRequest.getHonorarios();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Beneficiario getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Beneficiario idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public Documento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Documento idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
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

    public BigDecimal getHonorarios() {
        return honorarios;
    }

    public void setHonorarios(BigDecimal honorarios) {
        this.honorarios = honorarios;
    }

    @Override
    public String toString() {
        return "Tramite{" +
                "id=" + id +
                ", idDocumento=" + idDocumento +
                ", idBeneficiario=" + idBeneficiario +
                ", folio='" + folio + '\'' +
                ", fechaGeneracion=" + fechaGeneracion +
                ", fechaModifico=" + fechaModifico +
                ", fechaElimino=" + fechaElimino +
                ", honorarios=" + honorarios +
                '}';
    }
}

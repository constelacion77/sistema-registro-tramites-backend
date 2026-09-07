package com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Tramite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TramiteRequest {
    private Long id;
    private Long idDocumento;
    private Long idBeneficiario;
    private String folio;
    private LocalDateTime fechaGeneracion;
    private BigDecimal honorarios;
    private LocalDateTime fechaModifico;
    private LocalDateTime fechaElimino;

    public TramiteRequest(){}

    public TramiteRequest(Tramite tramite) {
        this.id = tramite.getId();
        this.idDocumento = tramite.getIdDocumento().getId();
        this.idBeneficiario = tramite.getIdBeneficiario().getId();
        this.folio = tramite.getFolio();
        this.fechaGeneracion = tramite.getFechaGeneracion();
        this.honorarios = tramite.getHonorarios();
        this.fechaModifico = tramite.getFechaModifico();
        this.fechaElimino = tramite.getFechaElimino();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Long getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Long idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
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

    public BigDecimal getHonorarios() {
        return honorarios;
    }

    public void setHonorarios(BigDecimal honorarios) {
        this.honorarios = honorarios;
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
        return "TramiteRequest{" +
                "id=" + id +
                ", idDocumento=" + idDocumento +
                ", idBeneficiario=" + idBeneficiario +
                ", folio='" + folio + '\'' +
                ", fechaGeneracion=" + fechaGeneracion +
                ", honorarios=" + honorarios +
                ", fechaModifico=" + fechaModifico +
                ", fechaElimino=" + fechaElimino +
                '}';
    }
}

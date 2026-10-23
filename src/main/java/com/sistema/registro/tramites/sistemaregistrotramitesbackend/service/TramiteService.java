package com.sistema.registro.tramites.sistemaregistrotramitesbackend.service;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.FiltroBusquedaDTO;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.TramiteRequest;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Tramite;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.repositorio.TramiteRepositorio;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.specification.TramiteSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TramiteService {
    private final TramiteRepositorio tramiteRepositorio;
    public TramiteService(TramiteRepositorio tramiteRepositorio) {
        this.tramiteRepositorio = tramiteRepositorio;
    }

    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private BeneficiarioService beneficiarioService;

    public Tramite guardarTramite(TramiteRequest entity){
        if(entity.getId() == null){
            entity.setFechaGeneracion(LocalDateTime.now());
        }else{
            entity.setFechaModifico(LocalDateTime.now());
        }
        Tramite tramite = new Tramite(entity);
        tramite.setIdDocumento(documentoService.obtenerDocumentoPorId(entity.getIdDocumento()));
        tramite.setIdBeneficiario(beneficiarioService.obtenerBeneficiarioPorId(entity.getIdBeneficiario()));

        return tramiteRepositorio.save(tramite);
    }

    public ResponseEntity<Void> eliminarTramite(Long idTramite){
        Optional<Tramite> optionalTramite = tramiteRepositorio.findById(idTramite);
        if(optionalTramite.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Tramite tramite = optionalTramite.get();
        tramite.setFechaElimino(LocalDateTime.now());
        tramiteRepositorio.save(tramite);
        return ResponseEntity.noContent().build();
    }

    public TramiteRequest obtenerTramiteById(Long idTramite){
        return new TramiteRequest(tramiteRepositorio.findByIdAndFechaEliminoIsNull(idTramite));
    }

    public Page<Tramite> buscarTramitesPorCampos(Pageable pageable, FiltroBusquedaDTO filtro){
        return tramiteRepositorio.findAll(TramiteSpecification.conFiltros(filtro), pageable);
    }
}

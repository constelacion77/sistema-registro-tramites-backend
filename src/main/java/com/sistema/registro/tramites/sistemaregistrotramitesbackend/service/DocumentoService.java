package com.sistema.registro.tramites.sistemaregistrotramitesbackend.service;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.FiltroBusquedaDTO;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.OpcionSelect;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Documento;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.repositorio.DocumentoRepositorio;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.specification.DocumentoSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {
    private final DocumentoRepositorio repositorio;

    public DocumentoService(DocumentoRepositorio documentoRepositorio){this.repositorio = documentoRepositorio;}

    public Documento obtenerDocumentoPorId(Long idDocumento){
        return repositorio.getById(idDocumento);
    }

    public Documento guardar(Documento entity){
        if(entity.getId() == null){
            entity.setFechaRegistro(LocalDateTime.now());
        }else{
            entity.setFechaModifico(LocalDateTime.now());
        }
        return repositorio.save(entity);
    }

    public ResponseEntity<Void> eliminar(Long id){
        Optional<Documento> optional = repositorio.findById(id);
        if(optional.isPresent()){
            Documento entity = optional.get();
            entity.setFechaElimino(LocalDateTime.now());
            repositorio.save(entity);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    public List<OpcionSelect> obtenerOpcionesDocumento(){
        return repositorio.findByFechaEliminoIsNullAndActivoIsTrue()
                .stream().map(d -> new OpcionSelect(d.getId(), d.getNombre()))
                .toList();
    }

    public Page<Documento> buscarDocumentosPorCampos(Pageable pageable, FiltroBusquedaDTO filtro){
        return repositorio.findAll(DocumentoSpecification.conFiltros(filtro), pageable);
    }
}

package com.sistema.registro.tramites.sistemaregistrotramitesbackend.controller;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.FiltroBusquedaDTO;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.OpcionSelect;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Documento;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class DocumentoController {
    @Autowired
    private DocumentoService service;

    @PostMapping("/documentos")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Documento guardarNuevoDocumento(@RequestBody Documento documento){
        return service.guardar(documento);
    }

    @PutMapping("/documentos")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Documento guardarDocumentoEditado(@RequestBody Documento documento){
        return service.guardar(documento);
    }

    @DeleteMapping("/documentos/{idDocumento}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long idDocumento){
        return service.eliminar(idDocumento);
    }

    @GetMapping("/documentos/opciones")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<OpcionSelect> obtenerOpcionesDocumentos(){
        return service.obtenerOpcionesDocumento();
    }

    @GetMapping("documentos/buscaqueda")
    public Page<Documento> buscarDocumentos(
            @PageableDefault(size = 5) Pageable pageable,
            @ModelAttribute FiltroBusquedaDTO filtro){
        return service.buscarDocumentosPorCampos(pageable, filtro);
    }
}

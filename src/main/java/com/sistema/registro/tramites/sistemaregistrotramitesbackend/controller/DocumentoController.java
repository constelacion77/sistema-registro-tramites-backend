package com.sistema.registro.tramites.sistemaregistrotramitesbackend.controller;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.OpcionSelect;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Documento;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class DocumentoController {
    @Autowired
    private DocumentoService service;

    @GetMapping("/documentos")
    public Page<Documento> obtenerDocumentos(
            @PageableDefault(size = 5)Pageable pageable
            ){
        return service.obtenerDocumentosActivos(pageable);
    }

    @PostMapping("/documentos")
    public Documento guardarNuevoDocumento(@RequestBody Documento documento){
        return service.guardar(documento);
    }

    @PutMapping("/documentos")
    public Documento guardarDocumentoEditado(@RequestBody Documento documento){
        return service.guardar(documento);
    }

    @DeleteMapping("/documentos/{idDocumento}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long idDocumento){
        return service.eliminar(idDocumento);
    }

    @GetMapping("/documentos/opciones")
    public List<OpcionSelect> obtenerOpcionesDocumentos(){
        return service.obtenerOpcionesDocumento();
    }
}

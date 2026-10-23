package com.sistema.registro.tramites.sistemaregistrotramitesbackend.controller;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.FiltroBusquedaDTO;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.TramiteRequest;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Tramite;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.service.TramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TramiteController {
    @Autowired
    private TramiteService service;

    @PostMapping("/tramites")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Tramite guardarNuevoTramite(@RequestBody TramiteRequest tramite){
        return service.guardarTramite(tramite);
    }

    @PutMapping("/tramites")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Tramite guardarTramiteEditado(@RequestBody TramiteRequest tramite){
        return service.guardarTramite(tramite);
    }

    @DeleteMapping("/tramites/{idTramite}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> eliminarTramite(@PathVariable Long idTramite){
        return service.eliminarTramite(idTramite);
    }

    @GetMapping("/tramites/{idTramite}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public TramiteRequest obtenerTramitePorId(@PathVariable Long idTramite){
        return service.obtenerTramiteById(idTramite);
    }

    @GetMapping("/tramites/busqueda")
    public Page<Tramite> buscarTramite(
            @PageableDefault(size = 5, sort = "fechaGeneracion", direction = Sort.Direction.DESC)Pageable pageable,
            @ModelAttribute FiltroBusquedaDTO filtro){
        return service.buscarTramitesPorCampos(pageable, filtro);
    }
}

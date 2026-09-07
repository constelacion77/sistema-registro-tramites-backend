package com.sistema.registro.tramites.sistemaregistrotramitesbackend.controller;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.TramiteRequest;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Tramite;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.repositorio.TramiteRepositorio;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.service.TramiteService;
import org.apache.coyote.Response;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TramiteController {
    @Autowired
    private TramiteService service;

    @GetMapping("/tramites")
    public Page<Tramite> obtenerTramites(
            @PageableDefault(size = 5) Pageable pageable
            ){
        return service.obtenerTramites(pageable);
    }

    @PostMapping("/tramites")
    public Tramite guardarNuevoTramite(@RequestBody TramiteRequest tramite){
        return service.guardarTramite(tramite);
    }

    @PutMapping("/tramites")
    public Tramite guardarTramiteEditado(@RequestBody TramiteRequest tramite){
        return service.guardarTramite(tramite);
    }

    @DeleteMapping("/tramites/{idTramite}")
    public ResponseEntity<Void> eliminarTramite(@PathVariable Long idTramite){
        return service.eliminarTramite(idTramite);
    }

    @GetMapping("/tramites/{idTramite}")
    public TramiteRequest obtenerTramitePorId(@PathVariable Long idTramite){
        return service.obtenerTramiteById(idTramite);
    }
}

package com.sistema.registro.tramites.sistemaregistrotramitesbackend.controller;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.FiltroBusquedaDTO;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.OpcionSelect;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Beneficiario;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BeneficiarioController {
    @Autowired
    private BeneficiarioService service;

    @PostMapping("/beneficiarios")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Beneficiario guardarNuevoBeneficiario(@RequestBody Beneficiario beneficiario){
        return service.guardar(beneficiario);
    }

    @PutMapping("/beneficiarios")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Beneficiario guardarBeneficiarioEditado(@RequestBody Beneficiario beneficiario){
        return service.guardar(beneficiario);
    }

    @DeleteMapping("/beneficiarios/{idBeneficiario}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> eliminarBeneficiario(@PathVariable Long idBeneficiario){
        return service.eliminar(idBeneficiario);
    }

    @GetMapping("/beneficiarios/opciones")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<OpcionSelect> obtenerOpcionesBeneficiarios(){
        return service.obtenerOpcionesBeneficiario();
    }

    @GetMapping("/beneficiarios/busqueda")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Page<Beneficiario> buscarBeneficiarios(
            @PageableDefault(size = 5)Pageable pageable,
            @ModelAttribute FiltroBusquedaDTO filtro){
        return service.buscarBeneficiarioPorCampos(pageable, filtro);
    }
}

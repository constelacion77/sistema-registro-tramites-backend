package com.sistema.registro.tramites.sistemaregistrotramitesbackend.controller;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.OpcionSelect;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Beneficiario;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BeneficiarioController {
    @Autowired
    private BeneficiarioService service;

    @GetMapping("/beneficiarios")
    public Page<Beneficiario> obtenerBeneficiarios(
            @PageableDefault(size = 5)Pageable pageable
            ){
        return service.obtenerBeneficiariosActivos(pageable);
    }

    @PostMapping("/beneficiarios")
    public Beneficiario guardarNuevoBeneficiario(@RequestBody Beneficiario beneficiario){
        return service.guardar(beneficiario);
    }

    @PutMapping("/beneficiarios")
    public Beneficiario guardarBeneficiarioEditado(@RequestBody Beneficiario beneficiario){
        return service.guardar(beneficiario);
    }

    @DeleteMapping("/beneficiarios/{idBeneficiario}")
    public ResponseEntity<Void> eliminarRepositorio(@PathVariable Long idBeneficiario){
        return service.eliminar(idBeneficiario);
    }

    @GetMapping("/beneficiarios/opciones")
    public List<OpcionSelect> obtenerOpcionesBeneficiarios(){
        return service.obtenerOpcionesBeneficiario();
    }
}

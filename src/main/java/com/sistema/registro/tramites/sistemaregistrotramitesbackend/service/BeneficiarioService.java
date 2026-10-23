package com.sistema.registro.tramites.sistemaregistrotramitesbackend.service;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.FiltroBusquedaDTO;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.OpcionSelect;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Beneficiario;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.repositorio.BeneficiarioRepositorio;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.specification.BeneficiarioSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService {
    private final BeneficiarioRepositorio repositorio;
    public BeneficiarioService(BeneficiarioRepositorio repositorio){this.repositorio = repositorio;}

    public Beneficiario obtenerBeneficiarioPorId(Long idBeneficiario){
        return repositorio.getById(idBeneficiario);
    }

    public Beneficiario guardar(Beneficiario entity){
        if(entity.getId() == null){
            entity.setFechaRegistro(LocalDateTime.now());
        }else{
            entity.setFechaModifico(LocalDateTime.now());
        }
        return repositorio.save(entity);
    }

    public ResponseEntity<Void> eliminar(Long id){
        Optional<Beneficiario> optional = repositorio.findById(id);
        if(optional.isPresent()) {
            Beneficiario entity = optional.get();
            entity.setFechaElimino(LocalDateTime.now());
            repositorio.save(entity);
        }else{
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    public List<OpcionSelect> obtenerOpcionesBeneficiario(){
        return repositorio.findByFechaEliminoIsNull().stream()
                .map(b -> new OpcionSelect(b.getId(), b.getNombreCompleto()))
                .toList();
    }

    public Page<Beneficiario> buscarBeneficiarioPorCampos(Pageable pageable, FiltroBusquedaDTO filtro){
        return repositorio.findAll(BeneficiarioSpecification.conFiltros(filtro), pageable);
    }
}

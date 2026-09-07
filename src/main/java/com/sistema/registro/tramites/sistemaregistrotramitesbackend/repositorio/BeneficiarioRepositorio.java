package com.sistema.registro.tramites.sistemaregistrotramitesbackend.repositorio;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Beneficiario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeneficiarioRepositorio extends JpaRepository<Beneficiario, Long> {
    public Beneficiario getById(Long id);

    public Page<Beneficiario> findByFechaEliminoIsNull(Pageable pageable);

    public List<Beneficiario> findByFechaEliminoIsNull();
}

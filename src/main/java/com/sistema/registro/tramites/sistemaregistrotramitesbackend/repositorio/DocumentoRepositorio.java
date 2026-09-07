package com.sistema.registro.tramites.sistemaregistrotramitesbackend.repositorio;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Documento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentoRepositorio extends JpaRepository<Documento, Long> {
    public Documento getById(Long id);

    public Page<Documento> findByFechaEliminoIsNullAndActivoIsTrue(Pageable pageable);

    public List<Documento> findByFechaEliminoIsNullAndActivoIsTrue();
}

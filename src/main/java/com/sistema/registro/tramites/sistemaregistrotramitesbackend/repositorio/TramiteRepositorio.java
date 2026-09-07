package com.sistema.registro.tramites.sistemaregistrotramitesbackend.repositorio;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Tramite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TramiteRepositorio extends JpaRepository<Tramite, Long> {
    //consulta para buscar los tramites sin eliminar
    public Page<Tramite> findByFechaEliminoIsNullOrderByFechaGeneracionDesc(Pageable pageable);

    //obtener tramite activo por id
    public Tramite findByIdAndFechaEliminoIsNull(Long id);
}

package com.sistema.registro.tramites.sistemaregistrotramitesbackend.specification;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.FiltroBusquedaDTO;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Tramite;
import jakarta.persistence.criteria.Expression;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;;

public class TramiteSpecification {
    public static Specification<Tramite> conFiltros(FiltroBusquedaDTO filtro){
        return (root, query, cb) ->{
            List<Predicate> predicados = new ArrayList<>();
            predicados.add(cb.isNull(root.get("fechaElimino")));

            if(existeFiltro(filtro.busqueda())){
                String patron = "%" + filtro.busqueda().toLowerCase().trim() + "%";
                var documento = root.get("idDocumento");
                var beneficiario = root.get("idBeneficiario");

                Expression<String> nombreCompleto = cb.concat(
                        cb.concat(
                                cb.coalesce(beneficiario.get("nombre"),""),
                                cb.literal(" ")
                        ),
                        cb.coalesce(beneficiario.get("apellidos"),"")
                );

                predicados.add(cb.or(
                        cb.like(cb.lower(documento.get("nombre")),patron),
                        cb.like(cb.lower(nombreCompleto),patron),
                        cb.like(cb.lower(root.get("folio")),patron)
                ));
            }
            return cb.and(predicados.toArray(new Predicate[0]));
        };
    }

    public static boolean existeFiltro(String filtro){
        return filtro != null && !filtro.isBlank();
    }
}

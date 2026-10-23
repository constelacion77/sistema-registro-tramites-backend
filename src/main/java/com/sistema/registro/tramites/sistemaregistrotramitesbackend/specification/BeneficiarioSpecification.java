package com.sistema.registro.tramites.sistemaregistrotramitesbackend.specification;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.FiltroBusquedaDTO;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Beneficiario;
import jakarta.persistence.criteria.Expression;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jakarta.persistence.criteria.Predicate;

public class BeneficiarioSpecification {
    public static Specification<Beneficiario> conFiltros(FiltroBusquedaDTO filtro){
        return (root, query, cb) ->{
            List<Predicate> predicados = new ArrayList<>();
            predicados.add(cb.isNull(root.get("fechaElimino")));

            if(contieneTexto(filtro.busqueda())){
                String patron = "%" + filtro.busqueda().toLowerCase().trim() + "%";
                Expression<String> nombreCompleto = cb.concat(
                        cb.concat(
                            cb.coalesce(root.get("nombre"),""), cb.literal(" ")
                        ),
                        cb.coalesce(root.get("apellidos"),"")
                );

                predicados.add(cb.or(
                   cb.like(cb.lower(root.get("nombre")),patron),
                   cb.like(cb.lower(root.get("apellidos")),patron),
                   cb.like(cb.lower(nombreCompleto),patron),
                   cb.like(cb.lower(root.get("curp")),patron)
                ));
            }
            return cb.and(predicados.toArray(new Predicate[0]));
        };
    }
    public static boolean contieneTexto(String texto){
        return texto != null && !texto.isBlank();
    }
}

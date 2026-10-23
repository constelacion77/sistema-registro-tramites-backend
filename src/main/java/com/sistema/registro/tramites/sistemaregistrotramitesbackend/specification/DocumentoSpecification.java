package com.sistema.registro.tramites.sistemaregistrotramitesbackend.specification;

import com.sistema.registro.tramites.sistemaregistrotramitesbackend.dto.FiltroBusquedaDTO;
import com.sistema.registro.tramites.sistemaregistrotramitesbackend.entity.Documento;
import jakarta.persistence.criteria.Expression;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import jakarta.persistence.criteria.Predicate;

public class DocumentoSpecification {
    public static Specification<Documento> conFiltros(FiltroBusquedaDTO filtro){
        return (root, query, cb) ->{
            List<Predicate> predicados = new ArrayList<>();
            predicados.add(cb.isNull(root.get("fechaElimino")));

            if(existeTexto(filtro.busqueda())){
                String patron = "%" + filtro.busqueda().toLowerCase().trim() + "%";
                Expression<String> costoString = cb.coalesce(cb.toString(root.get("costo")), "");

                predicados.add(cb.or(
                        cb.like(cb.lower(root.get("nombre")),patron),
                        cb.like(cb.lower(root.get("descripcion")),patron),
                        cb.like(costoString,patron)
                ));
            }
            return cb.and(predicados.toArray(new Predicate[0]));
        };
    }
    public static boolean existeTexto(String texto){
        return texto != null && !texto.isBlank();
    }
}

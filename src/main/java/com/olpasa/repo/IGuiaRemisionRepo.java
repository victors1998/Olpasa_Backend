package com.olpasa.repo;

import com.olpasa.dto.GuiaRemisionDTO;
import com.olpasa.dto.PesoDestare;
import com.olpasa.model.GuiaRemision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IGuiaRemisionRepo extends IGenericoRepo<GuiaRemision, Integer> {

    @Query(value = "select gr.id_guia, gr.fecha_emision, gr.serie, gr.numero,\n" +
            "CONCAT(per.paterno, ' ', per.materno, ' ', per.nombres) AS proveedor,\n" +
            "per.numero_documento, gr.peso_bruto, dg.unidad_medida, dg.descripcion\n" +
            "from guia_remision as gr \n" +
            "inner join persona as per on gr.codigo_destinatario=per.codigo\n" +
            "inner join detalle_guia as dg on gr.id_guia=dg.id_guia\n" +
            "WHERE gr.facturado='NO' AND gr.estado='EMITIDO'", nativeQuery = true)
    List<GuiaRemisionDTO> findGuiaRemisionFacturado();
}

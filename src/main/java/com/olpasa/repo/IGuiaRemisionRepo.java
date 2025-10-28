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

    @Query(value = "SELECT gr.id_guia, gr.fecha_emision, gr.serie, gr.numero, " +
            "CONCAT(per.paterno, ' ', per.materno, ' ', per.nombres) AS proveedor, " +
            "per.numero_documento, gr.peso_bruto, dg.unidad_medida, dg.descripcion, gr.facturado " +
            "FROM guia_remision AS gr " +
            "INNER JOIN persona AS per ON gr.codigo_destinatario = per.codigo " +
            "INNER JOIN detalle_guia AS dg ON gr.id_guia = dg.id_guia " +
            "WHERE gr.facturado = :facturado " +
            "AND gr.serie LIKE CONCAT('%', :serie, '%') " +
            "AND CAST(gr.numero AS VARCHAR) LIKE CONCAT('%', :numero)",
            nativeQuery = true)
    List<GuiaRemisionDTO> findByGuiaRemisionSerieNumero(
            @Param("facturado") String facturado,
            @Param("serie") String serie,
            @Param("numero") Integer numero);



}

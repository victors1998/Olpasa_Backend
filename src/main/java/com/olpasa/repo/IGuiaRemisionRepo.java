package com.olpasa.repo;

import com.olpasa.dto.GuiaDTO;
import com.olpasa.dto.GuiaRemisionDTO;
import com.olpasa.dto.PesoDestare;
import com.olpasa.model.GuiaRemision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
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

    @Query(value = "SELECT g.id_guia, g.fecha_emision, g.serie, g.numero, g.num_doc_destinatario,\n" +
            "dg.descripcion, dg.unidad_medida, CONCAT(p.nombres,' ',p.paterno,' ', p.materno) AS transportista,\n" +
            "CONCAT(cond.paterno, ' ', cond.materno, ' ', cond.nombres) AS conductores, peso.id_pesaje, peso.num_ticket,\n" +
            "peso.peso_ingreso, peso.peso_salida, peso.peso_neto, CONCAT(p3.nombres,' ',p3.paterno,' ',p3.materno) AS cliente,\n" +
            "v1.id_vehiculo as idVehiculoPrincipal, v1.placa AS placaPrincipal, v1.peso_max_permitido, v2.id_vehiculo as idVehiculoSecundario, v2.placa AS placaSecundario\n" +
            "FROM guia_remision AS g\n" +
            "INNER JOIN detalle_guia AS dg ON g.id_guia = dg.id_guia\n" +
            "INNER JOIN persona AS p ON g.codigo_et = p.codigo\n" +
            "INNER JOIN pesaje AS peso ON dg.id_pesaje = peso.id_pesaje\n" +
            "INNER JOIN persona AS p3 ON p3.codigo = g.codigo_destinatario\n" +
            "LEFT JOIN vehiculo AS v1 ON peso.id_vehiculo = v1.id_vehiculo\n" +
            "LEFT JOIN vehiculo AS v2 ON peso.vehiculo_id_vehiculo = v2.id_vehiculo\n" +
            "INNER JOIN conductor AS cond ON cond.codigo = g.codigo_cond " +
            "WHERE g.facturado = :facturado\n" +
            "AND g.serie LIKE CONCAT('%', :serie, '%')\n" +
            "AND CAST(g.numero AS VARCHAR) LIKE CONCAT('%', :numero)\n" +
            "ORDER BY g.id_guia DESC", nativeQuery = true)
    List<GuiaDTO> findByGuiaRemisionSerieNumero(
            @Param("facturado") String facturado,
            @Param("serie") String serie,
            @Param("numero") Integer numero);;

    @Query(value = "SELECT g.id_guia, g.fecha_emision, g.serie, g.numero, g.num_doc_destinatario, \n" +
            "dg.descripcion, dg.unidad_medida, CONCAT(p.nombres,' ',p.paterno,' ', p.materno) AS transportista,\n" +
            "CONCAT(cond.paterno, ' ', cond.materno, ' ', cond.nombres) AS conductores, peso.id_pesaje, peso.num_ticket,\n" +
            "peso.peso_ingreso, peso.peso_salida, peso.peso_neto, CONCAT(p3.nombres,' ',p3.paterno,' ',p3.materno) AS cliente, \n" +
            "v1.id_vehiculo as idVehiculoPrincipal, v1.placa AS placaPrincipal, v1.peso_max_permitido, v2.id_vehiculo as idVehiculoSecundario, v2.placa AS placaSecundario\n" +
            "FROM guia_remision AS g\n" +
            "INNER JOIN detalle_guia AS dg ON g.id_guia = dg.id_guia\n" +
            "INNER JOIN persona AS p ON g.codigo_et = p.codigo\n" +
            "INNER JOIN pesaje AS peso ON dg.id_pesaje = peso.id_pesaje\n" +
            "INNER JOIN persona AS p3 ON p3.codigo = g.codigo_destinatario\n" +
            "LEFT JOIN vehiculo AS v1 ON peso.id_vehiculo = v1.id_vehiculo\n" +
            "LEFT JOIN vehiculo AS v2 ON peso.vehiculo_id_vehiculo = v2.id_vehiculo\n" +
            "INNER JOIN conductor AS cond ON cond.codigo = g.codigo_cond\n" +
            "WHERE g.fecha_emision = :date ORDER BY g.id_guia DESC", nativeQuery = true)
    List<GuiaDTO> searchByFecha(@Param("date") LocalDate date);
}

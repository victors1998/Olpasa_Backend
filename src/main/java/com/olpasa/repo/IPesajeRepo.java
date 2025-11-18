package com.olpasa.repo;

import com.olpasa.dto.PesoDestare;
import com.olpasa.dto.PesoPruebaDTO;
import com.olpasa.model.ControlRff;
import com.olpasa.model.Pesaje;
import com.olpasa.model.Sector;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IPesajeRepo extends IGenericoRepo<Pesaje, Integer> {

    @Query(value = "SELECT pe.id_pesaje, pe.num_ticket,concat( per.paterno,' ', per.materno,' ', per.nombres) as proveedor,\n" +
            "ve.placa, concat( per2.paterno,' ', per2.materno,' ', per2.nombres) as transportista, pe.bitacora, pe.castigo_importe,\n" +
            "pe.castigo_peso, pe.castigo_planilla, pe.cod_producto, pe.codigo, pe.codigo_et, pe.conductor,\n" +
            "pe.estado, pe.estado_sinc, pe.fecha, pe.fecha_anul, pe.fecha_salida, pe.id_liquidacion,\n" +
            "pe.id_parcela, pe.id_to, pe.id_vehiculo, pe.monto_flete, pe.numero, pe.tipo_operacion,\n" +
            "pe.retencion_flete, pe.tipo_registro, pe.observaciones, pe.version, pe.usuario_ingreso,\n" +
            "pe.usuario_salida, pe.usuario_version, pe.reg_guia, pe.serie, pe.peso_ingreso, pe.peso_salida,\n" +
            "pe.peso_neto, pe.vehiculo_id_vehiculo\n" +
            "FROM pesaje AS pe INNER JOIN proveedor AS pro ON pe.codigo = pro.codigo\n" +
            "INNER JOIN persona AS per ON pe.codigo = per.codigo\n" +
            "INNER JOIN vehiculo AS ve ON pe.id_vehiculo = ve.id_vehiculo\n" +
            "LEFT JOIN persona AS per2 ON per2.codigo = pe.codigo_et\n" +
            "WHERE pe.estado = 'A' order by pe.id_pesaje", nativeQuery = true)
    List<PesoDestare> findPesajeByEstado();

    @Query(value = "SELECT pe.id_pesaje, pe.num_ticket,concat( per.paterno,' ', per.materno,' ', per.nombres) as proveedor,\n" +
            "ve.placa, concat( per2.paterno,' ', per2.materno,' ', per2.nombres) as transportista, pe.bitacora, pe.castigo_importe,\n" +
            "pe.castigo_peso, pe.castigo_planilla, pe.cod_producto, pe.codigo, pe.codigo_et, pe.conductor,\n" +
            "pe.estado, pe.estado_sinc, pe.fecha, pe.fecha_anul, pe.fecha_salida, pe.id_liquidacion,\n" +
            "pe.id_parcela, pe.id_to, pe.id_vehiculo, pe.monto_flete, pe.numero, pe.tipo_operacion,\n" +
            "pe.retencion_flete, pe.tipo_registro, pe.observaciones, pe.version, pe.usuario_ingreso,\n" +
            "pe.usuario_salida, pe.usuario_version, pe.reg_guia, pe.serie, pe.peso_ingreso, pe.peso_salida,\n" +
            "pe.peso_neto, pe.vehiculo_id_vehiculo\n" +
            "FROM pesaje AS pe INNER JOIN proveedor AS pro ON pe.codigo = pro.codigo\n" +
            "INNER JOIN persona AS per ON pe.codigo = per.codigo\n" +
            "INNER JOIN vehiculo AS ve ON pe.id_vehiculo = ve.id_vehiculo\n" +
            "LEFT JOIN persona AS per2 ON per2.codigo = pe.codigo_et\n" +
            "WHERE pe.id_pesaje = :id_pesaje order by pe.id_pesaje", nativeQuery = true)
    PesoDestare findPesajeById_pesaje(@Param("id_pesaje") Integer id_pesaje);

    @Query(value = "SELECT pe.id_pesaje, pe.num_ticket,concat( per.paterno,' ', per.materno,' ', per.nombres) as proveedor,\n" +
            "            ve.placa, concat( per2.paterno,' ', per2.materno,' ', per2.nombres) as transportista, pe.bitacora, pe.castigo_importe,\n" +
            "            pe.castigo_peso, pe.castigo_planilla, pe.cod_producto, pe.codigo, pe.codigo_et, pe.conductor,\n" +
            "            pe.estado, pe.estado_sinc, pe.fecha, pe.fecha_anul, pe.fecha_salida, pe.id_liquidacion,\n" +
            "            pe.id_parcela, pe.id_to, pe.id_vehiculo, pe.monto_flete, pe.numero, pe.tipo_operacion,\n" +
            "            pe.retencion_flete, pe.tipo_registro, pe.observaciones, pe.version, pe.usuario_ingreso,\n" +
            "            pe.usuario_salida, pe.usuario_version, pe.reg_guia, pe.serie, pe.peso_ingreso, pe.peso_salida,\n" +
            "            pe.peso_neto, pe.vehiculo_id_vehiculo\n" +
            "            FROM pesaje AS pe INNER JOIN proveedor AS pro ON pe.codigo = pro.codigo\n" +
            "            INNER JOIN persona AS per ON pe.codigo = per.codigo\n" +
            "            INNER JOIN vehiculo AS ve ON pe.id_vehiculo = ve.id_vehiculo\n" +
            "            LEFT JOIN persona AS per2 ON per2.codigo = pe.codigo_et\n" +
            "            WHERE pe.codigo= :codigo AND YEAR(pe.fecha) = :anio AND MONTH(pe.fecha) = :mes ", nativeQuery = true)
    List<PesoDestare> searchProveedorAnioMes(@Param("codigo") Integer codigo, @Param("anio") Integer anio, @Param("mes") Integer mes);

    @Query(value = "SELECT pe.id_pesaje, pe.num_ticket,concat( per.paterno,' ', per.materno,' ', per.nombres) as proveedor,\n" +
            "            ve.placa, concat( per2.paterno,' ', per2.materno,' ', per2.nombres) as transportista, pe.bitacora, pe.castigo_importe,\n" +
            "            pe.castigo_peso, pe.castigo_planilla, pe.cod_producto, pe.codigo, pe.codigo_et, pe.conductor,\n" +
            "            pe.estado, pe.estado_sinc, pe.fecha, pe.fecha_anul, pe.fecha_salida, pe.id_liquidacion,\n" +
            "            pe.id_parcela, pe.id_to, pe.id_vehiculo, pe.monto_flete, pe.numero, pe.tipo_operacion,\n" +
            "            pe.retencion_flete, pe.tipo_registro, pe.observaciones, pe.version, pe.usuario_ingreso,\n" +
            "            pe.usuario_salida, pe.usuario_version, pe.reg_guia, pe.serie, pe.peso_ingreso, pe.peso_salida,\n" +
            "            pe.peso_neto, pe.vehiculo_id_vehiculo\n" +
            "            FROM pesaje AS pe INNER JOIN proveedor AS pro ON pe.codigo = pro.codigo\n" +
            "            INNER JOIN persona AS per ON pe.codigo = per.codigo\n" +
            "            INNER JOIN vehiculo AS ve ON pe.id_vehiculo = ve.id_vehiculo\n" +
            "            LEFT JOIN persona AS per2 ON per2.codigo = pe.codigo_et\n" +
            "            WHERE pe.fecha= :date ", nativeQuery = true)
    List<PesoDestare> searchByFecha(@Param("date") LocalDate date);

    @Query(value = "SELECT \n" +
            "    pe.id_pesaje, \n" +
            "    pe.num_ticket,\n" +
            "    CONCAT(per.paterno, ' ', per.materno, ' ', per.nombres) AS proveedor,\n" +
            "    ve.placa,\n" +
            "    CONCAT(per2.paterno, ' ', per2.materno, ' ', per2.nombres) AS transportista,\n" +
            "    CONCAT(cond.paterno, ' ', cond.materno, ' ', cond.nombres) AS conductores,\n" +
            "    pe.bitacora, pe.castigo_importe, pe.castigo_peso, pe.castigo_planilla,\n" +
            "    pe.cod_producto, pe.codigo, pe.codigo_et, pe.conductor, pe.estado, pe.estado_sinc,\n" +
            "    pe.fecha, pe.fecha_anul, pe.fecha_salida, pe.id_liquidacion, pe.id_parcela, pe.id_to,\n" +
            "    pe.id_vehiculo, pe.monto_flete, pe.numero, pe.tipo_operacion, pe.retencion_flete,\n" +
            "    pe.tipo_registro, pe.observaciones, pe.version, pe.usuario_ingreso, pe.usuario_salida,\n" +
            "    pe.usuario_version, pe.reg_guia, pe.serie, pe.peso_ingreso, pe.peso_salida, \n" +
            "    pe.peso_neto, pe.vehiculo_id_vehiculo, prod.descripcion, cond.licencia, pe.observaciones\n" +
            "FROM pesaje AS pe\n" +
            "LEFT JOIN proveedor AS pro ON pe.codigo = pro.codigo\n" +
            "LEFT JOIN persona AS per ON pe.codigo = per.codigo\n" +
            "LEFT JOIN vehiculo AS ve ON pe.id_vehiculo = ve.id_vehiculo\n" +
            "LEFT JOIN persona AS per2 ON per2.codigo = pe.codigo_et\n" +
            "LEFT JOIN producto AS prod ON pe.cod_producto = prod.cod_producto\n" +
            "LEFT JOIN (\n" +
            "    SELECT codigo_et, MIN(codigo) AS id_conductor\n" +
            "    FROM conductor\n" +
            "    GROUP BY codigo_et\n" +
            ") AS cond_sel ON cond_sel.codigo_et = pe.codigo_et\n" +
            "LEFT JOIN conductor AS cond ON cond.codigo = cond_sel.id_conductor\n" +
            "WHERE pe.num_ticket = :num_ticket\n" +
            "ORDER BY pe.id_pesaje;", nativeQuery = true)
    List<PesoDestare> findPesajeById_NumTicket(@Param("num_ticket") String num_ticket);

    @Query(value = "SELECT pe.tipo_operacion, SUM(pe.peso_neto) AS peso_neto, p.descripcion " +
            "FROM pesaje as pe inner join producto as p on pe.cod_producto=p.cod_producto " +
            "WHERE pe.fecha_salida BETWEEN :inicio AND :fin " +
            "GROUP BY pe.tipo_operacion, p.descripcion",
            nativeQuery = true)
    List<PesoPruebaDTO> resumenHastaHora(@Param("inicio") LocalDateTime inicio, @Param("fin") LocalDateTime fin);



}

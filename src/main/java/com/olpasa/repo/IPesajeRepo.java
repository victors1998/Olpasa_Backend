package com.olpasa.repo;

import com.olpasa.dto.PesoDestare;
import com.olpasa.model.ControlRff;
import com.olpasa.model.Pesaje;
import com.olpasa.model.Sector;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPesajeRepo extends IGenericoRepo<Pesaje, Integer> {

    @Query(value = "SELECT pe.id_pesaje, pe.num_ticket,concat( per.paterno,' ', per.materno,'', per.nombres) as proveedor,\n" +
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


}

package com.olpasa.repo;

import com.olpasa.dto.PMDto;
import com.olpasa.dto.PesoDestare;
import com.olpasa.model.PesoMedida;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IPesoMedidaRepo extends IGenericoRepo<PesoMedida, Integer> {

    @Query(value = "SELECT \n" +
            "    pm.id_peso_medida,\n" +
            "    pm.fecha, pm.estado,\n" +
            "    pe.num_ticket, pe.peso_salida,\n" +
            "    gr.serie,\n" +
            "    gr.numero,\n" +
            "    \n" +
            "    -- Datos del proveedor\n" +
            "    CONCAT(p.paterno, ' ', p.materno, ' ', p.nombres) AS proveedor,\n" +
            "    \n" +
            "    -- Datos del transportista\n" +
            "    CONCAT(per2.paterno, ' ', per2.materno, ' ', per2.nombres) AS transportista,\n" +
            "    \n" +
            "    -- Vehículo principal\n" +
            "    v1.id_vehiculo AS id_vehiculo_principal,\n" +
            "    v1.placa AS placa_principal,\n" +
            "    v1.alto AS alto_principal,\n" +
            "    v1.ancho AS ancho_principal,\n" +
            "    v1.largo AS largo_principal,\n" +
            "v1.configuracion_vehicular as configuracion,\n" +
            "v1.peso_max_permitido as peso_permitido,\n" +
            "    \n" +
            "    -- Vehículo secundario (por ejemplo, remolque o carreta)\n" +
            "    v2.id_vehiculo AS id_vehiculo_secundario,\n" +
            "    v2.placa AS placa_secundario,\n" +
            "    v2.alto AS alto_secundario,\n" +
            "    v2.ancho AS ancho_secundario,\n" +
            "    v2.largo AS largo_secundario\n" +
            "    \n" +
            "FROM peso_medida AS pm\n" +
            "INNER JOIN pesaje AS pe \n" +
            "    ON pm.id_pesaje = pe.id_pesaje\n" +
            "INNER JOIN guia_remision AS gr \n" +
            "    ON pm.id_guia = gr.id_guia\n" +
            "LEFT JOIN vehiculo AS v1 \n" +
            "    ON pe.id_vehiculo = v1.id_vehiculo\n" +
            "LEFT JOIN vehiculo AS v2 \n" +
            "    ON pe.vehiculo_id_vehiculo = v2.id_vehiculo\n" +
            "INNER JOIN persona AS p \n" +
            "    ON pe.codigo = p.codigo\n" +
            "LEFT JOIN persona AS per2 \n" +
            "    ON pe.codigo_et = per2.codigo\n" +
            "WHERE pm.fecha= :date", nativeQuery = true)
    List<PMDto> searchByFecha(@Param("date") LocalDate date);

    @Query(value = "SELECT \n" +
            "    pm.id_peso_medida AS idPesoMedida,\n" +
            "    pm.fecha AS fecha,\n" +
            "    pm.estado AS estado,\n" +
            "    pe.num_ticket AS numTicket,\n" +
            "    pe.peso_salida AS pesoSalida,\n" +
            "    gr.serie AS serie,\n" +
            "    gr.numero AS numero,\n" +
            "    \n" +
            "    -- Datos del proveedor\n" +
            "    CONCAT(p.paterno, ' ', p.materno, ' ', p.nombres) AS proveedor,\n" +
            "    \n" +
            "    -- Datos del transportista\n" +
            "    CONCAT(per2.paterno, ' ', per2.materno, ' ', per2.nombres) AS transportista,\n" +
            "    \n" +
            "    -- Vehículo principal\n" +
            "    v1.id_vehiculo AS idVehiculoPrincipal,\n" +
            "    v1.placa AS placaPrincipal,\n" +
            "    v1.alto AS altoPrincipal,\n" +
            "    v1.ancho AS anchoPrincipal,\n" +
            "    v1.largo AS largoPrincipal,\n" +
            "    v1.configuracion_vehicular AS configuracion,\n" +
            "    v1.peso_max_permitido AS pesoPermitido,\n" +
            "    \n" +
            "    -- Vehículo secundario\n" +
            "    v2.id_vehiculo AS idVehiculoSecundario,\n" +
            "    v2.placa AS placaSecundario,\n" +
            "    v2.alto AS altoSecundario,\n" +
            "    v2.ancho AS anchoSecundario,\n" +
            "    v2.largo AS largoSecundario\n" +
            "    \n" +
            "FROM peso_medida pm\n" +
            "INNER JOIN pesaje pe ON pm.id_pesaje = pe.id_pesaje\n" +
            "INNER JOIN guia_remision gr ON pm.id_guia = gr.id_guia\n" +
            "LEFT JOIN vehiculo v1 ON pe.id_vehiculo = v1.id_vehiculo\n" +
            "LEFT JOIN vehiculo v2 ON pe.vehiculo_id_vehiculo = v2.id_vehiculo\n" +
            "INNER JOIN persona p ON pe.codigo = p.codigo\n" +
            "LEFT JOIN persona per2 ON pe.codigo_et = per2.codigo\n" +
            "WHERE pm.id_peso_medida = :id_peso_medida", nativeQuery = true)
    PMDto searchById_peso_medida(@Param("id_peso_medida") Integer id_peso_medida);


    @Modifying
    @Query("UPDATE PesoMedida p SET p.estado = 'ANULADO' WHERE p.id_peso_medida = :idPesoMedida")
    int anularById(@Param("idPesoMedida") Integer idPesoMedida);

}

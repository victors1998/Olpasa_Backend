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

    @Query(value = "SELECT pm.id_peso_medida, pm.fecha, gr.serie, gr.numero, pm.num_registro, \n" +
            "CONCAT(p1.nombres, ' ',p1.paterno, ' ', p1.materno) AS cliente,\n" +
            "CONCAT(p2.nombres, ' ',p2.paterno, ' ', p2.materno) AS empresaTransporte,\n" +
            "v1.id_vehiculo, v1.placa as placaPrincipal, v1.configuracion_vehicular, \n" +
            "pm.peso_max_perm, v2.id_vehiculo, v2.placa as placaSecundario, pm.peso_bruto_transp,\n" +
            "pm.estado FROM peso_medida as pm\n" +
            "INNER JOIN guia_remision AS gr on pm.id_guia=gr.id_guia\n" +
            "INNER JOIN pesaje AS pe on pm.id_pesaje=pe.id_pesaje\n" +
            "INNER JOIN persona as p1 on pe.codigo=p1.codigo\n" +
            "INNER JOIN persona as p2 on pe.codigo_et=p2.codigo\n" +
            "LEFT JOIN vehiculo AS v1 on pm.id_vehiculo=v1.id_vehiculo\n" +
            "LEFT JOIN vehiculo AS v2 on pm.id_vehiculo2=v2.id_vehiculo\n" +
            "WHERE pm.fecha= :date", nativeQuery = true)
    List<PMDto> searchByFecha(@Param("date") LocalDate date);

    @Query(value = "SELECT pm.id_peso_medida, pm.fecha, gr.serie, gr.numero, pm.num_registro,\n" +
            "CONCAT(p1.nombres, ' ',p1.paterno, ' ', p1.materno) AS cliente,\n" +
            "CONCAT(p2.nombres, ' ',p2.paterno, ' ', p2.materno) AS empresTransporte,\n" +
            "v1.id_vehiculo, v1.placa as placaPrincipal, v1.configuracion_vehicular,\n" +
            "v1.largo as largoPrincipal, v1.ancho as anchoPrincipal, v1.alto as altoPrincipal,\n" +
            "pm.peso_max_perm, v2.id_vehiculo, v2.placa as placaSecundario,\n" +
            "v2.largo as largoSecundario, v2.ancho as anchoSecundario, v2.alto as altoSecundario,\n" +
            "pm.peso_bruto_transp, pm.estado FROM peso_medida as pm\n" +
            "INNER JOIN guia_remision AS gr on pm.id_guia=gr.id_guia\n" +
            "INNER JOIN pesaje AS pe on pm.id_pesaje=pe.id_pesaje\n" +
            "INNER JOIN persona as p1 on pe.codigo=p1.codigo\n" +
            "INNER JOIN persona as p2 on pe.codigo_et=p2.codigo\n" +
            "LEFT JOIN vehiculo AS v1 on pm.id_vehiculo=v1.id_vehiculo\n" +
            "LEFT JOIN vehiculo AS v2 on pm.id_vehiculo2=v2.id_vehiculo " +
            "WHERE pm.id_peso_medida= :id_peso_medida", nativeQuery = true)
    PMDto searchById_peso_medida(@Param("id_peso_medida") Integer id_peso_medida);


    @Modifying
    @Query("UPDATE PesoMedida p SET p.estado = 'ANULADO' WHERE p.id_peso_medida = :idPesoMedida")
    int anularById(@Param("idPesoMedida") Integer idPesoMedida);

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN CAST(1 AS BIT)\n" +
            "ELSE CAST(0 AS BIT)\n" +
            "END AS existe\n" +
            "FROM peso_medida\n" +
            "WHERE id_guia= :id_guia AND estado='EMITIDO'", nativeQuery = true)
    boolean existsByGuia(@Param("id_guia") Integer id_guia);

}

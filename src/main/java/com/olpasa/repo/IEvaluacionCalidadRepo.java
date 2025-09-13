package com.olpasa.repo;

import com.olpasa.model.ControlRff;
import com.olpasa.model.EvaluacionCalidad;
import com.olpasa.model.Sector;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEvaluacionCalidadRepo extends IGenericoRepo<EvaluacionCalidad, Integer> {

    @Query(value = "SELECT * FROM evaluacion_calidad e WHERE id_pesaje=?1 and estado='Activo'", nativeQuery = true)
    List<EvaluacionCalidad> buscarIdPesaje(Integer id_pesaje);

    @Query(value = "SELECT CASE \n" +
            "           WHEN COUNT(*) > 0 THEN CAST(1 AS BIT) \n" +
            "           ELSE CAST(0 AS BIT) \n" +
            "       END AS existe\n" +
            "FROM evaluacion_calidad\n" +
            "WHERE id_pesaje = :id_pesaje \n" +
            "  AND id_criterio = :id_criterio \n" +
            "  AND estado = 'ACTIVO'", nativeQuery = true)
    boolean existsByPesajeAndCriterioActivo(@Param("id_pesaje") Integer id_pesaje, @Param("id_criterio") Integer id_criterio);
}

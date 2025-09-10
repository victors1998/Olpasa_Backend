package com.olpasa.repo;

import com.olpasa.model.ControlRff;
import com.olpasa.model.EvaluacionCalidad;
import com.olpasa.model.Sector;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEvaluacionCalidadRepo extends IGenericoRepo<EvaluacionCalidad, Integer> {

    @Query(value = "SELECT * FROM evaluacion_calidad e WHERE id_pesaje=?1 and estado='Activo'", nativeQuery = true)
    List<EvaluacionCalidad> buscarIdPesaje(Integer id_pesaje);

    @Query(value = "update evaluacion_calidad set estado='Anulado' where id_evaluacion=?1", nativeQuery = true)
    EvaluacionCalidad deleteEvaluacionCalidadByEstado(Integer id_evaluacion);
}

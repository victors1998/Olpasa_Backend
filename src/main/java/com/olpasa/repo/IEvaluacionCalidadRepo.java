package com.olpasa.repo;

import com.olpasa.model.ControlRff;
import com.olpasa.model.EvaluacionCalidad;
import com.olpasa.model.Sector;
import org.springframework.data.jpa.repository.Query;

public interface IEvaluacionCalidadRepo extends IGenericoRepo<EvaluacionCalidad, Integer> {

    @Query(value = "SELECT * FROM evaluacion_calidad e WHERE id_pesaje=?1", nativeQuery = true)
    ControlRff buscarIdPesaje(Integer id_pesaje);
}

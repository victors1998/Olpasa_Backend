package com.olpasa.service;

import com.olpasa.model.EvaluacionCalidad;
import com.olpasa.model.Sector;

import java.util.List;


public interface IEvaluacionCalidadService extends ICRUD<EvaluacionCalidad, Integer>{


    List<EvaluacionCalidad> findByIdPesaje(Integer idPesaje);
}

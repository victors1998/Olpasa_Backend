package com.olpasa.service.impl;

import com.olpasa.model.EvaluacionCalidad;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IEvaluacionCalidadRepo;
import com.olpasa.service.IEvaluacionCalidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluacionCalidadServiceImpl extends CRUDImpl<EvaluacionCalidad, Integer> implements IEvaluacionCalidadService {

    private final IEvaluacionCalidadRepo evaluacionCalidadRepo;

    @Override
    protected IGenericoRepo<EvaluacionCalidad, Integer> getRepo() {
        return evaluacionCalidadRepo;
    }

    @Override
    public List<EvaluacionCalidad> findByIdPesaje(Integer idPesaje) {
        return  evaluacionCalidadRepo.buscarIdPesaje(idPesaje);
    }

    @Override
    public EvaluacionCalidad eliminarEvaluacionCalidad(Integer id_evaluacion) {
        EvaluacionCalidad evaluacion = evaluacionCalidadRepo.findById(id_evaluacion).orElseThrow(() -> new RuntimeException("No se encontro el id del evaluacion"));
        evaluacion.setEstado("Anulado");
        return evaluacionCalidadRepo.save(evaluacion);
    }

}

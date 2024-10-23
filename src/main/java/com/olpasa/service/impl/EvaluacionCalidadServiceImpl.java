package com.olpasa.service.impl;

import com.olpasa.model.EvaluacionCalidad;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IEvaluacionCalidadRepo;
import com.olpasa.service.IEvaluacionCalidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvaluacionCalidadServiceImpl extends CRUDImpl<EvaluacionCalidad, Integer> implements IEvaluacionCalidadService {

    private final IEvaluacionCalidadRepo evaluacionCalidadRepo;

    @Override
    protected IGenericoRepo<EvaluacionCalidad, Integer> getRepo() {
        return evaluacionCalidadRepo;
    }
}

package com.olpasa.service.impl;

import com.olpasa.model.CriterioCalidad;
import com.olpasa.model.Sector;
import com.olpasa.repo.ICriterioCalidadRepo;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.ISectorRepo;
import com.olpasa.service.ICriterioCalidadService;
import com.olpasa.service.ISectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriterioCalidadServiceImpl extends CRUDImpl<CriterioCalidad, Integer> implements ICriterioCalidadService {

    private final ICriterioCalidadRepo criterioCalidadRepo;

    @Override
    protected IGenericoRepo<CriterioCalidad, Integer> getRepo() {
        return criterioCalidadRepo;
    }
}

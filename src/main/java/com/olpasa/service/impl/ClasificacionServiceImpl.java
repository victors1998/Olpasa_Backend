package com.olpasa.service.impl;

import com.olpasa.model.Clasificacion;
import com.olpasa.repo.IClasificacionRepo;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.service.IClasificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClasificacionServiceImpl extends CRUDImpl<Clasificacion, Integer> implements IClasificacionService {

    private final IClasificacionRepo repo;

    @Override
    protected IGenericoRepo<Clasificacion, Integer> getRepo() {
        return repo;
    }

}

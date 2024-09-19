package com.olpasa.service.impl;

import com.olpasa.model.ClasificacionContable;
import com.olpasa.repo.IClasificacionContableRepo;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.service.IClasificacionContableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClasificacionContableServiceImpl extends CRUDImpl<ClasificacionContable, Integer> implements IClasificacionContableService {

    private final IClasificacionContableRepo clasificacionContableRepo;

    @Override
    protected IGenericoRepo<ClasificacionContable, Integer> getRepo() {
        return clasificacionContableRepo;
    }
}

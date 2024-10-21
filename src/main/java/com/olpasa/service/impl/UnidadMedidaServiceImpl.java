package com.olpasa.service.impl;

import com.olpasa.model.UnidadMedida;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IUnidadMedidaRepo;
import com.olpasa.service.IUnidadMedidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnidadMedidaServiceImpl extends CRUDImpl<UnidadMedida, String> implements IUnidadMedidaService {

    private final IUnidadMedidaRepo unidadMedidaRepo;

    @Override
    protected IGenericoRepo<UnidadMedida, String> getRepo() {
        return unidadMedidaRepo;
    }
}

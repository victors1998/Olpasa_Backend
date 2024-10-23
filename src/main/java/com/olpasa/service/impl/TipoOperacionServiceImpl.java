package com.olpasa.service.impl;

import com.olpasa.model.TipoOperacion;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.ITipoOperacionRepo;
import com.olpasa.service.ITipoOperacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipoOperacionServiceImpl extends CRUDImpl<TipoOperacion, Integer> implements ITipoOperacionService {

    private final ITipoOperacionRepo tipoOperacionRepo;

    @Override
    protected IGenericoRepo<TipoOperacion, Integer> getRepo() {
        return tipoOperacionRepo;
    }
}

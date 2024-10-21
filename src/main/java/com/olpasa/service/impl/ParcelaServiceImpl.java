package com.olpasa.service.impl;

import com.olpasa.model.Parcela;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IParcelaRepo;
import com.olpasa.service.IParcelaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParcelaServiceImpl extends CRUDImpl<Parcela, Integer> implements IParcelaService {

    private final IParcelaRepo parcelaRepo;

    @Override
    protected IGenericoRepo<Parcela, Integer> getRepo() {
        return parcelaRepo;
    }
}

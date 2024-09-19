package com.olpasa.service.impl;

import com.olpasa.model.Conductor;
import com.olpasa.repo.IConductorRepo;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.service.ICondutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConductorServiceImpl extends CRUDImpl<Conductor, Integer> implements ICondutorService {

    private final IConductorRepo conductorRepo;

    @Override
    protected IGenericoRepo<Conductor, Integer> getRepo() {
        return null;
    }
}

package com.olpasa.service.impl;

import com.olpasa.model.GuiaRemision;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.service.IGuiaRemisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuiaRemisionServiceImpl extends CRUDImpl<GuiaRemision, Integer> implements IGuiaRemisionService {
    @Override
    protected IGenericoRepo<GuiaRemision, Integer> getRepo() {
        return null;
    }
}

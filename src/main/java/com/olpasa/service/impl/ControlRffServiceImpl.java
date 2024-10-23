package com.olpasa.service.impl;

import com.olpasa.model.ControlRff;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IControlRffRepo;
import com.olpasa.service.IControlRffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ControlRffServiceImpl extends CRUDImpl<ControlRff, Integer> implements IControlRffService {

    private final IControlRffRepo controlRffRepo;

    @Override
    protected IGenericoRepo<ControlRff, Integer> getRepo() {
        return controlRffRepo;
    }
}

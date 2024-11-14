package com.olpasa.service.impl;

import com.olpasa.model.ControlRff;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IControlRffRepo;
import com.olpasa.service.IControlRffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ControlRffServiceImpl extends CRUDImpl<ControlRff, Integer> implements IControlRffService {

    private final IControlRffRepo controlRffRepo;

    @Override
    protected IGenericoRepo<ControlRff, Integer> getRepo() {
        return controlRffRepo;
    }

    @Override
    public List<ControlRff> buscarPorIdPesaje(Integer id_pesaje) {
        return controlRffRepo.buscarIdPesaje(id_pesaje);
    }
}

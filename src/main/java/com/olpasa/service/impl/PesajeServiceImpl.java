package com.olpasa.service.impl;

import com.olpasa.model.Pesaje;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IPesajeRepo;
import com.olpasa.service.IPesajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PesajeServiceImpl extends CRUDImpl<Pesaje, Integer> implements IPesajeService {

    private final IPesajeRepo pesajeRepo;

    @Override
    protected IGenericoRepo<Pesaje, Integer> getRepo() {
        return pesajeRepo;
    }

    @Override
    public List<Pesaje> findPesajeByEstado() {
        return pesajeRepo.findPesajeByEstado();
    }

}

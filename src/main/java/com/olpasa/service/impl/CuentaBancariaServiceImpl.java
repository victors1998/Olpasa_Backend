package com.olpasa.service.impl;

import com.olpasa.model.CuentaBancaria;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.ICuentaBancariaRepo;
import com.olpasa.service.ICuentaBancariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CuentaBancariaServiceImpl extends CRUDImpl<CuentaBancaria, Integer> implements ICuentaBancariaService {

    private final ICuentaBancariaRepo cuentaBancariaRepo;

    @Override
    protected IGenericoRepo<CuentaBancaria, Integer> getRepo() {
        return cuentaBancariaRepo;
    }
}

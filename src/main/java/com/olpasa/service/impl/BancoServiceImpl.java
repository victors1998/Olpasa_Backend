package com.olpasa.service.impl;

import com.olpasa.model.Banco;
import com.olpasa.repo.IBancoRepo;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.service.IBancoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BancoServiceImpl  extends CRUDImpl<Banco, Integer> implements IBancoService {

    private final IBancoRepo bancoRepo;


    @Override
    protected IGenericoRepo<Banco, Integer> getRepo() {
        return bancoRepo;
    }
}

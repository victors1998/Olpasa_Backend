package com.olpasa.service.impl;

import com.olpasa.model.Privilegio;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IPrivilegioRepo;
import com.olpasa.service.IPrivilegioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrivilegioServiceImpl extends CRUDImpl<Privilegio, Integer> implements IPrivilegioService {

    private final IPrivilegioRepo privilegioRepo;

    @Override
    protected IGenericoRepo<Privilegio, Integer> getRepo() {
        return privilegioRepo;
    }

    @Override
    public List<Privilegio> getUsuarioPrivilegiosPorNombre(String nombre_cuenta) {
        return privilegioRepo.getPrivilegioByUsername(nombre_cuenta);
    }
}

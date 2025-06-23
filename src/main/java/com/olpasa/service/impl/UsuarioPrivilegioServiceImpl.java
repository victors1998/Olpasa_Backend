package com.olpasa.service.impl;

import com.olpasa.model.Privilegio;
import com.olpasa.model.UsuarioPrivilegio;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IUsuarioPrivilegioRepo;
import com.olpasa.service.IUsuarioPrivilegioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioPrivilegioServiceImpl extends CRUDImpl<Privilegio, Integer> implements IUsuarioPrivilegioService {

    private final IUsuarioPrivilegioRepo usuarioPrivilegioRepo;

    @Override
    protected IGenericoRepo<Privilegio, Integer> getRepo() {
        return usuarioPrivilegioRepo;
    }


}

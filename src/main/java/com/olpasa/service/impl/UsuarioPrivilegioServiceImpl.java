package com.olpasa.service.impl;

import com.olpasa.model.UsuarioPrivilegio;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IUsuarioPrivilegioRepo;
import com.olpasa.service.IUsuarioPrivilegioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioPrivilegioServiceImpl extends CRUDImpl<UsuarioPrivilegio, Integer> implements IUsuarioPrivilegioService {

    private final IUsuarioPrivilegioRepo usuarioPrivilegioRepo;

    @Override
    protected IGenericoRepo<UsuarioPrivilegio, Integer> getRepo() {
        return usuarioPrivilegioRepo;
    }
}

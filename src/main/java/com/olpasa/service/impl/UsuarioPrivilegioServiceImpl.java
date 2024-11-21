package com.olpasa.service.impl;

import com.olpasa.model.UsuarioPrivilegio;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IUsuarioPrivilegioRepo;
import com.olpasa.service.IUsuarioPrivilegioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioPrivilegioServiceImpl extends CRUDImpl<UsuarioPrivilegio, Integer> implements IUsuarioPrivilegioService {

    private final IUsuarioPrivilegioRepo usuarioPrivilegioRepo;

    @Override
    protected IGenericoRepo<UsuarioPrivilegio, Integer> getRepo() {
        return usuarioPrivilegioRepo;
    }

    @Override
    public List<UsuarioPrivilegio> getUsuarioPrivilegiosPorNombre() {
        String contextUser = SecurityContextHolder.getContext().getAuthentication().getName();
        return usuarioPrivilegioRepo.obtenerPrivilegiosPorUsuario(contextUser);
    }
}

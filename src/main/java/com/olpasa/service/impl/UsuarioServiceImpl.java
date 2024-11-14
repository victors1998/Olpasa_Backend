package com.olpasa.service.impl;

import com.olpasa.model.Usuario;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IUsuarioRepo;
import com.olpasa.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioService {

    private final IUsuarioRepo usuarioRepo;

    @Override
    protected IGenericoRepo<Usuario, Integer> getRepo() {
        return usuarioRepo;
    }
}

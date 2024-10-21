package com.olpasa.service.impl;

import com.olpasa.model.Persona;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IPersonaRepo;
import com.olpasa.service.IPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl extends CRUDImpl<Persona, Integer> implements IPersonaService {

    private final IPersonaRepo personaRepo;

    @Override
    protected IGenericoRepo<Persona, Integer> getRepo() {
        return personaRepo;
    }
}

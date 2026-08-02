package com.olpasa.service.impl;

import com.olpasa.dto.SDTO;
import com.olpasa.model.Solicitud;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.ISolicitudRepo;
import com.olpasa.service.ISolicitudSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl extends CRUDImpl<Solicitud, Integer> implements ISolicitudSevice {

    private final ISolicitudRepo solicitudRepo;


    @Override
    protected IGenericoRepo<Solicitud, Integer> getRepo() {
        return solicitudRepo;
    }

    @Override
    public List<SDTO> solicitudesPendientes() {
        return solicitudRepo.solicitudesPendientes();
    }
}

package com.olpasa.service.impl;

import com.olpasa.dto.GuiaDTO;
import com.olpasa.dto.GuiaRemisionDTO;
import com.olpasa.dto.PesoDestare;
import com.olpasa.model.GuiaRemision;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IGuiaRemisionRepo;
import com.olpasa.repo.IPesajeRepo;
import com.olpasa.service.IGuiaRemisionService;
import com.olpasa.service.IPesajeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GuiaRemisionServiceImpl extends CRUDImpl<GuiaRemision, Integer> implements IGuiaRemisionService {

    private final IGuiaRemisionRepo guiaRemisionRepo;

    @Override
    protected IGenericoRepo<GuiaRemision, Integer> getRepo() {
        return guiaRemisionRepo;
    }

    @Override
    public List<GuiaRemisionDTO> findGuiaRemisionFacturado() {
        return guiaRemisionRepo.findGuiaRemisionFacturado();
    }

    @Override
    public List<GuiaDTO> findGuiaRemisionSerieNumero(String facturado, String serie, Integer numero) {
        return guiaRemisionRepo.findByGuiaRemisionSerieNumero(facturado, serie, numero);
    }

    @Override
    public List<GuiaDTO> searchByDate(LocalDate date) {
        return guiaRemisionRepo.searchByFecha(date);
    }
}

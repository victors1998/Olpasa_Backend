package com.olpasa.service.impl;

import com.olpasa.dto.PMDto;
import com.olpasa.model.PesoMedida;
import com.olpasa.repo.IGenericoRepo;
import com.olpasa.repo.IPesoMedidaRepo;
import com.olpasa.service.IPesoMedidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PesoMedidaServiceImpl extends CRUDImpl<PesoMedida, Integer> implements IPesoMedidaService {

    private final IPesoMedidaRepo pesoMedidaRepo;

    @Override
    protected IGenericoRepo<PesoMedida, Integer> getRepo() {
        return pesoMedidaRepo;
    }

    @Override
    public List<PMDto> searchByDate(LocalDate date) {
        return pesoMedidaRepo.searchByFecha(date);
    }
}

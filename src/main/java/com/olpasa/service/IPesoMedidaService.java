package com.olpasa.service;

import com.olpasa.dto.PMDto;
import com.olpasa.dto.PesoDestare;
import com.olpasa.model.PesoMedida;
import com.olpasa.service.impl.CRUDImpl;

import java.time.LocalDate;
import java.util.List;

public interface IPesoMedidaService extends ICRUD<PesoMedida, Integer> {

    List<PMDto> searchByDate(LocalDate date);
}

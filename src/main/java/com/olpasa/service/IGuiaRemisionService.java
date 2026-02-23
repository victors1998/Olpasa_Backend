package com.olpasa.service;

import com.olpasa.dto.GuiaDTO;
import com.olpasa.dto.GuiaRemisionDTO;
import com.olpasa.dto.PesoDestare;
import com.olpasa.model.GuiaRemision;

import java.time.LocalDate;
import java.util.List;

public interface IGuiaRemisionService extends ICRUD<GuiaRemision, Integer>{

    List<GuiaRemisionDTO> findGuiaRemisionFacturado();

    List<GuiaDTO> findGuiaRemisionSerieNumero(String facturado, String serie, Integer numero);

    List<GuiaDTO> searchByDate(LocalDate date);
}

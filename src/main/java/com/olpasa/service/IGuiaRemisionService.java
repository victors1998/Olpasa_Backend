package com.olpasa.service;

import com.olpasa.dto.GuiaRemisionDTO;
import com.olpasa.dto.PesoDestare;
import com.olpasa.model.GuiaRemision;

import java.util.List;

public interface IGuiaRemisionService extends ICRUD<GuiaRemision, Integer>{

    List<GuiaRemisionDTO> findGuiaRemisionFacturado();
}

package com.olpasa.service;

import com.olpasa.dto.SDTO;
import com.olpasa.model.Solicitud;

import java.util.List;

public interface ISolicitudSevice extends ICRUD<Solicitud, Integer>{

    List<SDTO> solicitudesPendientes();
}

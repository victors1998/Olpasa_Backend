package com.olpasa.service;

import com.olpasa.dto.EmpresaDTO;
import com.olpasa.model.EmpresaTransporte;

import java.util.List;

public interface IEmpresaTransporteService extends ICRUD<EmpresaTransporte, Integer>{

    List<EmpresaDTO> findEmpresaTransporte();
}

package com.olpasa.service;

import com.olpasa.dto.VehiculoDTO;
import com.olpasa.model.Vehiculo;

import java.util.List;


public interface IVehiculoService extends ICRUD<Vehiculo, Integer>{

    List<VehiculoDTO> findVehiculos();

}

package com.olpasa.service;

import com.olpasa.dto.PesoDestare;
import com.olpasa.model.ControlRff;
import com.olpasa.model.Pesaje;
import com.olpasa.model.Sector;

import java.util.List;


public interface IPesajeService extends ICRUD<Pesaje, Integer>{

    List<PesoDestare> findPesajeByEstado();

    PesoDestare getPesajeById_pesaje(Integer id_pesaje);

    List<PesoDestare> searchProveedorAnioMes(Integer codigo, Integer anio, Integer mes);

}

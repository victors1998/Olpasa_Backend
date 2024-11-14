package com.olpasa.service;

import com.olpasa.model.ControlRff;
import com.olpasa.model.Pesaje;
import com.olpasa.model.Sector;

import java.util.List;


public interface IPesajeService extends ICRUD<Pesaje, Integer>{

    List<Pesaje> listarPorEstado();

    List<Pesaje> buscarPorIdPesaje(Integer id_pesaje);
}

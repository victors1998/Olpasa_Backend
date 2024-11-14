package com.olpasa.service;

import com.olpasa.model.ControlRff;
import com.olpasa.model.Pesaje;
import com.olpasa.model.Sector;

import java.util.List;


public interface IControlRffService extends ICRUD<ControlRff, Integer>{

    List<ControlRff> buscarPorIdPesaje(Integer id_pesaje);
}

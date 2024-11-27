package com.olpasa.service;

import com.olpasa.model.Privilegio;

import java.util.List;

public interface IPrivilegioService{

    List<Privilegio> getUsuarioPrivilegiosPorNombre(String nombre_cuenta);
}
